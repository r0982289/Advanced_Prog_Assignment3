import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeManagerSystem {

    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("please provide a valid employee.");
        }
        employees.add(employee);
    }

    public void removeEmployee(String id) {
        employees.removeIf(emp -> emp.getEmployeeID().equals(id));
    }

    public Employee findEmployee(String id) {
        for (Employee emp : employees) {
            if (emp.getEmployeeID().equals(id)) {
                return emp;
            }
        }
        return null;
    }

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees); // copy
    }

    public void validateEmploymentType(Employee employee) {
        EmploymentType type = employee.getEmplType();

        if (type == null) {
            throw new IllegalStateException(
                    "Employee " + employee.getEmployeeID() + " does not have an employment type.");
        }

        if (!(type instanceof FulltimeEmployment || type instanceof ParttimeEmployment)) {
            throw new IllegalStateException(
                    "Employee " + employee.getEmployeeID() +
                            " has an invalid employment type. Must be Full-Time or Part-Time.");
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
