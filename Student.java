// using interface
interface Displayable{
  void display();
}

//Parent class
abstract class Student implements Displayable{
  protected int id;
  protected String name;
  protected int age;

  public Student(int id, String name, int age){
    this.id = id;
    this.name = name;
    this.age = age;
  }

  public int getId(){return id; }
  public String getName(){return name;}

  public abstract String toFileString();
}

//child class-1
class LocalStudent extends Students{
  private String district;

  public LocalStudent(int id, String name, int age, String district){
    super(id, name, age)
    this.district = district;
  }

  public void display(){
    System.out.println("[Local] ID: " + id + ", Name: "+ name + ", Age: " + age + ", District: "+ district);
  }

  public String toFileString(){
    return "LOCAL," + id + "," + name + "," + age + "," + district;
  }
}


//child class-2
class ForeignStudent extends Student {
    private String country;

    public ForeignStudent(int id, String name, int age, String country) {
        super(id, name, age);
        this.country = country;
    }

    public void display() {
        System.out.println("[Foreign] ID: " + id + ", Name: " + name + ", Age: " + age + ", Country: " + country);
    }

  
    public String toFileString() {
        return "FOREIGN," + id + "," + name + "," + age + "," + country;
    }

}
