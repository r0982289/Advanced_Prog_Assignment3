import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import exceptions.*;

public class Manager extends Employee {

    private List<Employee> teamMembers = new ArrayList<>();

    public Manager(String firstName, String lastName, Date dateOfBirth,
            String employeeID, Position position, Manager manager,
            EmploymentType emplType) {

        super(firstName, lastName, dateOfBirth, employeeID, position, manager, emplType);
    }

    public void addTeamMember(Employee employee) {
        try {
            if (employee == null) {
                throw new InvalidExceptions("Cannot add null employee to team");
            }
            
            teamMembers.add(employee);
            employee.setManager(this);
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void removeTeamMember(Employee employee) {
        try {
            if (employee == null) {
                throw new InvalidExceptions("Cannot remove null employee");
            }
            
            if (employee.getManager() == this) {
                employee.setManager(null);
            }
            teamMembers.remove(employee);
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public List<Employee> getTeamMembers() {
        return new ArrayList<>(teamMembers);
    }

    public void receiveReport(Employee employee, String reportMessage) {
        try {
            if (employee == null) {
                throw new InvalidExceptions("Employee cannot be null");
            }
            if (reportMessage == null || reportMessage.trim().isEmpty()) {
                throw new InvalidExceptions("Report message cannot be empty");
            }
            
            System.out.println("Manager " + getFirstName() + " " + getLastName() +
                    " received report from " + employee.getFirstName() + " " + employee.getLastName() +
                    ": " + reportMessage);
                    
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void conductPerformanceReview(Employee employee) {
        try {
            if (employee == null) {
                throw new InvalidExceptions("Cannot review null employee");
            }
            
            System.out.println("Manager " + getFirstName() + " " + getLastName() +
                    " is conducting a performance review for " +
                    employee.getFirstName() + " " + employee.getLastName() + ".");
                    
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}