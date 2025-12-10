import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Manager extends Employee {

    private List<Employee> teamMembers = new ArrayList<>();

    public Manager(String firstName, String lastName, Date dateOfBirth,
            String employeeID, Position position, Manager manager,
            EmploymentType emplType) {

        super(firstName, lastName, dateOfBirth, employeeID, position, manager, emplType);

    }

    public void addTeamMember(Employee employee) {
        if (employee == null) {
            throw new IllegalArgumentException("please provide a valid employee.");
        }

        teamMembers.add(employee);

        // assigning this manager to the employee
        employee.setManager(this);
    }

    public void removeTeamMember(Employee employee) {

        // remove manager reference
        if (employee.getManager() == this) {
            employee.setManager(null);
        }
        teamMembers.remove(employee);

    }

    public List<Employee> getTeamMembers() {
        return new ArrayList<>(teamMembers);
    }

    public void receiveReport(Employee employee, String reportMessage) {
        System.out.println("Manager " + getFirstName() + getLastName() +
                " received report from " + employee.getFirstName() + employee.getLastName() +
                ": " + reportMessage);
    }

    public void conductPerformanceReview(Employee employee) {
        System.out.println("Manager " + getFirstName() + getLastName() +
                " is conducting a performance review for " +
                employee.getFirstName() + employee.getLastName() + ".");
    }
}
