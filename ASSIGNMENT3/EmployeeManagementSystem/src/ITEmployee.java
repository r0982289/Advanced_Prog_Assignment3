import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ITEmployee extends Employee {

    private List<String> technicalSkills = new ArrayList<>();

    public ITEmployee(String firstName, String lastName, Date dateOfBirth,
            String employeeID, Position position, Manager manager,
            EmploymentType emplType) {
        super(firstName, lastName, dateOfBirth, employeeID, position, manager, emplType);
    }

    public void addTechnicalSkill(String skill) {
        if (skill != null && !skill.isEmpty()) {
            technicalSkills.add(skill);
        }
    }

    public List<String> getTechnicalSkills() {
        return new ArrayList<>(technicalSkills);
    }
}
