import java.io.*;
import java.util.*;

public class StudentManagementSystem {

    static ArrayList<Student> students = new ArrayList<Student>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n--- STUDENT MANAGEMENT SYSTEM ---");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student");
            System.out.println("3. Delete Student");
            System.out.println("4. Display All");
            System.out.println("5. Save to File");
            System.out.println("6. Exit");
            System.out.print("Choose: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                addStudent();
            } else if (choice == 2) {
                searchStudent();
            } else if (choice == 3) {
                deleteStudent();
            } else if (choice == 4) {
                displayAll();
            } else if (choice == 5) {
                saveToFile();
            } else if (choice == 6) {
                System.exit(0);
            } else {
                System.out.println("Invalid choice");
            }
        }
    }

    static void addStudent() {

        System.out.print("ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("1.Local  2.Foreign: ");
        int type = sc.nextInt();
        sc.nextLine();

        if (type == 1) {
            System.out.print("District: ");
            String district = sc.nextLine();
            students.add(new LocalStudent(id, name, age, district));
        } else {
            System.out.print("Country: ");
            String country = sc.nextLine();
            students.add(new ForeignStudent(id, name, age, country));
        }

        System.out.println("Student Added Successfully!");
    }

    static void searchStudent() {

        System.out.print("Enter ID or Name: ");
        String key = sc.next();

        boolean found = false;

        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);

            if (String.valueOf(s.getId()).equals(key) ||
                s.getName().equalsIgnoreCase(key)) {

                s.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student Not Found");
        }
    }

    static void deleteStudent() {

        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        boolean removed = false;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                removed = true;
                break;
            }
        }

        if (removed) {
            System.out.println("Student Deleted");
        } else {
            System.out.println("Student Not Found");
        }
    }

    static void displayAll() {

        if (students.isEmpty()) {
            System.out.println("No Students Available");
            return;
        }

        for (int i = 0; i < students.size(); i++) {
            students.get(i).display(); // polymorphism
        }
    }

    static void saveToFile() {

        try {
            FileWriter fw = new FileWriter("students.txt");
            PrintWriter pw = new PrintWriter(fw);

            for (int i = 0; i < students.size(); i++) {
                pw.println(students.get(i).toFileString());
            }

            pw.close();
            System.out.println("Saved to students.txt");

        } catch (IOException e) {
            System.out.println("File Error");
        }
    }
}
