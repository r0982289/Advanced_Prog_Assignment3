import java.util.Date;

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

        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.employeeID = employeeID;
        this.position = position;
        this.manager = manager;
        this.emplType = emplType;
    }

    // setters and getters

    public void reportToManager(String reportMessage) {
        if (manager == null) {
            throw new IllegalStateException("No manager assigned to report to.");
        }

        // Notifying manager
        manager.receiveReport(this, reportMessage);
    }

    // Returning the manager of the employee
    public Manager getManager() {
        return this.manager;
    }

    // Setting a new manager
    public void setManager(Manager manager) {
        this.manager = manager;
    }

    // Returning position
    public String getPositionName() {
        return (position != null) ? position.getPositionName() : null;
    }

    // Returning department of employee
    public Department getDepartment() {
        return (position != null) ? position.getDepartment() : null;
    }

    // overridden by Permanent or Temporary employee
    public double getPaid() {
        return emplType.calculatePay(); // dynamic binding here
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
        this.position = position;
    }

    public void setEmploymentType(EmploymentType emplType) {
        this.emplType = emplType;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}
