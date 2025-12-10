import java.util.Date;
import exceptions.*;

public class Employee {

    // Fields
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String employeeID;
    private Position position;
    private Manager manager;
    private EmploymentType emplType;

    public Employee(String firstName, String lastName, Date dateOfBirth,
            String employeeID, Position position,
            Manager manager, EmploymentType emplType) {

        try {
            if (firstName == null || firstName.trim().isEmpty()) {
                throw new InvalidExceptions("First name cannot be empty");
            }
            if (lastName == null || lastName.trim().isEmpty()) {
                throw new InvalidExceptions("Last name cannot be empty");
            }
            if (employeeID == null || employeeID.trim().isEmpty()) {
                throw new InvalidEmployeeIdException("Employee ID cannot be empty");
            }
            if (employeeID.length() < 5) {
                throw new InvalidEmployeeIdException("Employee ID must be at least 5 characters");
            }
            
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateOfBirth = dateOfBirth;
            this.employeeID = employeeID;
            this.position = position;
            this.manager = manager;
            this.emplType = emplType;
            
        } catch (InvalidExceptions | InvalidEmployeeIdException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void reportToManager(String reportMessage) {
        try {
            if (manager == null) {
                throw new InvalidExceptions("No manager assigned to report to");
            }
            if (reportMessage == null || reportMessage.trim().isEmpty()) {
                throw new InvalidExceptions("Report message cannot be empty");
            }
            
            manager.receiveReport(this, reportMessage);
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public Manager getManager() {
        return this.manager;
    }

    public void setManager(Manager manager) {
        try {
            // Allow null manager (some employees like CEO have no manager)
            this.manager = manager;
            
        } catch (Exception e) {
            System.err.println("Error setting manager: " + e.getMessage());
        }
    }

    public String getPositionName() {
        return (position != null) ? position.getPositionName() : null;
    }

    public Department getDepartment() {
        return (position != null) ? position.getDepartment() : null;
    }

    public double getPaid() {
        try {
            if (emplType == null) {
                throw new InvalidExceptions("Employment type not set");
            }
            return emplType.calculatePay();
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
            return 0.0;
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public Position getPosition() {
        return position;
    }

    public EmploymentType getEmplType() {
        return emplType;
    }

    public void setPosition(Position position) {
        try {
            if (position == null) {
                throw new InvalidExceptions("Position cannot be null");
            }
            this.position = position;
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void setEmploymentType(EmploymentType emplType) {
        try {
            if (emplType == null) {
                throw new InvalidExceptions("Employment type cannot be null");
            }
            this.emplType = emplType;
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}