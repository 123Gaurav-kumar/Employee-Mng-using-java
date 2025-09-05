import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;

    // Constructor
    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    // Display employee details
    public void displayEmployee() {
        System.out.println("ID: " + id + ", Name: " + name + ", Salary: $" + salary);
    }
}

class EmployeeManagementSystem {
    private ArrayList<Employee> employees;

    public EmployeeManagementSystem() {
        employees = new ArrayList<>();
    }

    // Create - Add new employee
    public void addEmployee(Employee emp) {
        employees.add(emp);
        System.out.println("Employee added successfully.");
    }

    // Read - View all employees
    public void viewEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
            return;
        }
        System.out.println("Employee List:");
        for (Employee emp : employees) {
            emp.displayEmployee();
        }
    }

    // Update employee details by ID
    public boolean updateEmployee(int id, String newName, double newSalary) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                emp.setName(newName);
                emp.setSalary(newSalary);
                System.out.println("Employee updated successfully.");
                return true;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
        return false;
    }

    // Delete employee by ID
    public boolean deleteEmployee(int id) {
        for (Employee emp : employees) {
            if (emp.getId() == id) {
                employees.remove(emp);
                System.out.println("Employee deleted successfully.");
                return true;
            }
        }
        System.out.println("Employee with ID " + id + " not found.");
        return false;
    }
}

public class Main {
    public static void main(String[] args) {
        EmployeeManagementSystem ems = new EmployeeManagementSystem();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nEmployee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Employee Salary: ");
                    double salary = scanner.nextDouble();
                    Employee emp = new Employee(id, name, salary);
                    ems.addEmployee(emp);
                    break;

                case 2:
                    ems.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    System.out.print("Enter new salary: ");
                    double newSalary = scanner.nextDouble();
                    ems.updateEmployee(updateId, newName, newSalary);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = scanner.nextInt();
                    ems.deleteEmployee(deleteId);
                    break;

                case 5:
                    System.out.println("Exiting Employee Management System.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
