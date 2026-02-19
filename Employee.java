import java.io.*;

public class Employee {
    private int empId;
    private String name;
    private double basicSalary;

    // Default Constructor
    public Employee() {
    }

    // Parameterized Constructor
    public Employee(int empId, String name, double basicSalary) {
        this.empId = empId;
        this.name = name;
        this.basicSalary = basicSalary;
    }

    // Calculate Net Salary
    public double calculateNetSalary() {
        double hra = basicSalary * 0.20;
        double da = basicSalary * 0.10;
        return basicSalary + hra + da;
    }

    // Method Overloading
    public void display() {
        System.out.println("ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Basic Salary: " + basicSalary);
    }

    public void display(boolean showNet) {
        display();
        if (showNet) {
            System.out.println("Net Salary: " + calculateNetSalary());
        }
    }

    // Convert object to file format
    public String toFileString() {
        return empId + "," + name + "," + basicSalary;
    }

    // Getters
    public int getEmpId() {
        return empId;
    }
}
