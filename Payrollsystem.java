import java.io.*;
import java.util.*;

public class Payrollsystem {

    static final String FILE_NAME = "employees.txt";
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n---- Employee Payroll Menu ----");
            System.out.println("1. Add Employee");
            System.out.println("2. Display All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    displayEmployees();
                    break;
                case 3:
                    searchEmployee();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 4);
    }

    // Add Employee
    static void addEmployee() {
        try {
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Basic Salary: ");
            double salary = sc.nextDouble();

            Employee emp = new Employee(id, name, salary);

            FileWriter fw = new FileWriter(FILE_NAME, true);
            fw.write(emp.toFileString() + "\n");
            fw.close();

            System.out.println("Employee saved successfully!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Display All Employees
    static void displayEmployees() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            System.out.println("\nEmployee Records:");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                Employee emp = new Employee(
                        Integer.parseInt(data[0]),
                        data[1],
                        Double.parseDouble(data[2])
                );
                emp.display(true);
                System.out.println("-------------------");
            }

            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("No records found.");
        } catch (Exception e) {
            System.out.println("Error reading file.");
        }
    }

    // Search Employee
    static void searchEmployee() {
        System.out.print("Enter Employee ID to search: ");
        int searchId = sc.nextInt();

        boolean found = false;

        try {
            BufferedReader br = new BufferedReader(new FileReader(FILE_NAME));
            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");

                if (Integer.parseInt(data[0]) == searchId) {
                    Employee emp = new Employee(
                            Integer.parseInt(data[0]),
                            data[1],
                            Double.parseDouble(data[2])
                    );
                    System.out.println("Employee Found:");
                    emp.display(true);
                    found = true;
                    break;
                }
            }

            br.close();

            if (!found) {
                System.out.println("Employee not found.");
            }

        } catch (Exception e) {
            System.out.println("Error searching file.");
        }
    }
}
