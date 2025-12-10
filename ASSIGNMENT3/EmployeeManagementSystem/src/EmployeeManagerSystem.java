import java.io.*;
import java.util.ArrayList;
import java.util.List;

import exceptions.InvalidEmployeeIdException;
import exceptions.InvalidExceptions;

public class EmployeeManagerSystem {

    private List<Employee> employees = new ArrayList<>();

      public void addEmployee(Employee employee) {
        try {
            if (employee == null) {
                throw new InvalidExceptions("Cannot add null employee");
            }
            employees.add(employee);
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void removeEmployee(String id) {
        try {
            if (id == null || id.trim().isEmpty()) {
                throw new InvalidEmployeeIdException("Employee ID cannot be empty");
            }
            employees.removeIf(emp -> emp.getEmployeeID().equals(id));
            
        } catch (InvalidEmployeeIdException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public Employee findEmployee(String id) {
        try {
            if (id == null || id.trim().isEmpty()) {
                throw new InvalidEmployeeIdException("Employee ID cannot be empty");
            }
            
            for (Employee emp : employees) {
                if (emp.getEmployeeID().equals(id)) {
                    return emp;
                }
            }
            return null;
            
        } catch (InvalidEmployeeIdException e) {
            System.err.println("Error: " + e.getMessage());
            return null;
        }
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees); // copy
    }

        public void validateEmploymentType(Employee employee) {
        try {
            if (employee == null) {
                throw new InvalidExceptions("Employee cannot be null");
            }
            
            EmploymentType type = employee.getEmplType();

            if (type == null) {
                throw new InvalidExceptions(
                        "Employee " + employee.getEmployeeID() + " does not have an employment type.");
            }

            if (!(type instanceof FulltimeEmployment || type instanceof ParttimeEmployment)) {
                throw new InvalidExceptions(
                        "Employee " + employee.getEmployeeID() +
                                " has an invalid employment type. Must be Full-Time or Part-Time.");
            }
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void saveToFile() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("employees.data"))) {
            out.writeObject(employees);
            System.out.println("Employees saved successfully.");
        } catch (IOException e) {
            System.err.println("Error saving employees: " + e.getMessage());
        }
    }

    public void loadFromFile() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("employees.data"))) {
            employees = (List<Employee>) in.readObject();
            System.out.println("Employees loaded successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("No previous saved file found.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading employees: " + e.getMessage());
        }
    }

    public String generateReport() {
        StringBuilder sb = new StringBuilder();

        sb.append("EMPLOYEE REPORT\n");
        sb.append("=====================\n");

        for (Employee emp : employees) {
            sb.append("ID: ").append(emp.getEmployeeID()).append("\n");
            sb.append("Name: ").append(emp.getFirstName()).append("\n");
            sb.append("Position: ").append(emp.getPosition()).append("\n");
            sb.append("Department: ").append(emp.getDepartment()).append("\n");
            sb.append("Employment Type: ").append(emp.getEmplType().getEmploymentStatus()).append("\n");
            sb.append("Pay This Period: ").append(emp.getPaid()).append("\n");
            sb.append("-----\n");
        }

        return sb.toString();
    }
}
