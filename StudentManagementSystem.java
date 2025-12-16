import java.io.*;
import java.util.*;

public class StudentManagementSystem {
    static ArrayList<Student> students = new ArrayList<>();
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

            switch (choice) {
                case 1 -> addStudent();
                case 2 -> searchStudent();
                case 3 -> deleteStudent();
                case 4 -> displayAll();
                case 5 -> saveToFile();
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid choice");
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
        System.out.print("Enter name or ID: ");
        String key = sc.next();

        for (Student s : students) {
            if (String.valueOf(s.getId()).equals(key) || s.getName().equalsIgnoreCase(key)) {
                s.display();
                return;
            }
        }
        System.out.println("Student Not Found");
    }

    static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        students.removeIf(s -> s.getId() == id);
        System.out.println("Deleted if existed");
    }

    static void displayAll() {
        for (Student s : students) {
            s.display(); // polymorphism
        }
    }

    static void saveToFile() {
        try (PrintWriter pw = new PrintWriter(new FileWriter("students.txt"))) {
            for (Student s : students) {
                pw.println(s.toFileString());
            }
            System.out.println("Saved to students.txt");
        } catch (IOException e) {
            System.out.println("File Error");
        }
    }
}
