import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import exceptions.*;

public class AdminEmployee extends Employee {

    private List<String> responsibilities = new ArrayList<>();

    public AdminEmployee(String firstName, String lastName, Date dateOfBirth,
            String employeeID, Position position, Manager manager,
            EmploymentType emplType) {
        super(firstName, lastName, dateOfBirth, employeeID, position, manager, emplType);
    }

    public void addResponsibility(String responsibility) {
        try {
            if (responsibility == null || responsibility.trim().isEmpty()) {
                throw new InvalidExceptions("Responsibility cannot be empty");
            }
            responsibilities.add(responsibility);
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public List<String> getResponsibilities() {
        return new ArrayList<>(responsibilities);
    }
}