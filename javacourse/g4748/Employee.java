/*
   Programmed by Sergii Kozhushko 2022
   Date of creation: 25-Nov-2022 
*/

package edu.javacourse.g4748;
/*
Programmed by Sergii Kozhushko
*/

public class Employee {

    public final String COMPANY_NAME = "NYCE Hotel";
    private int Id;
    static int Counter;
    public String FirstName;
    public String LastName;
    private String Role;
    private int Salary;
    private int Age;


    static {
        Counter = 1005;
    }

    Employee(String fname, String lname, String role, int salary, int age){
        this.Role = role;
        this.Salary = salary;
        this.Age = age;
        this.FirstName = fname;
        this.LastName = lname;
        this.Id = Counter++;
    }
    Employee(){
        this.Role = "Unknown";
        this.LastName = "Unknown";
        this.Salary = 0;
        this.Id = Counter++;
    }

    int getAge(){
        return Age;
    }

    public String toString(){
        return "Employee(id:" + this.Id + ", " + this.FirstName + " " + this.LastName + ", " + this.Role + ", $" + this.Salary+", "+this.Age + " years)";
    }
    public static void main(String[] args) {
        Employee em1 = new Employee("Ivan","Ivanov","Boss",1000, 42);
        Employee em2 = new Employee("Petr","Petrov","Manager",500, 28);
        Employee em3 = new Employee("Maria", "Vasileva","Secretar",300, 22);
        System.out.println(em3);
        //Employee em2 = new Employee();
    }
}


