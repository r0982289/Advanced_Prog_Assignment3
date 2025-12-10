import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import exceptions.*;

public class ITEmployee extends Employee {

    private List<String> technicalSkills = new ArrayList<>();

    public ITEmployee(String firstName, String lastName, Date dateOfBirth,
            String employeeID, Position position, Manager manager,
            EmploymentType emplType) {
        super(firstName, lastName, dateOfBirth, employeeID, position, manager, emplType);
    }

    public void addTechnicalSkill(String skill) {
        try {
            if (skill == null || skill.trim().isEmpty()) {
                throw new InvalidExceptions("Technical skill cannot be empty");
            }
            technicalSkills.add(skill);
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public List<String> getTechnicalSkills() {
        return new ArrayList<>(technicalSkills);
    }
}