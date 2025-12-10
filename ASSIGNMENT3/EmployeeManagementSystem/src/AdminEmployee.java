import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AdminEmployee extends Employee {

    private List<String> responsibilities = new ArrayList<>();

    public AdminEmployee(String firstName, String lastName, Date dateOfBirth,
            String employeeID, Position position, Manager manager,
            EmploymentType emplType) {
        super(firstName, lastName, dateOfBirth, employeeID, position, manager, emplType);
    }

    public void addResponsibility(String responsibility) {
        if (responsibility != null && !responsibility.isEmpty()) {
            responsibilities.add(responsibility);
        }
    }

    public List<String> getResponsibilities() {
        return new ArrayList<>(responsibilities);
    }
}
