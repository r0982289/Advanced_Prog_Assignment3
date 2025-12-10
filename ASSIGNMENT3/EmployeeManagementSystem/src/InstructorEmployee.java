import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InstructorEmployee extends Employee {

    private List<String> coursesTaught = new ArrayList<>();
    private String specialization;

    public InstructorEmployee(String firstName, String lastName, Date dateOfBirth,
            String employeeID, Position position, Manager manager,
            EmploymentType emplType, String specialization) {
        super(firstName, lastName, dateOfBirth, employeeID, position, manager, emplType);
        this.specialization = specialization;
    }

    public void addCourse(String course) {
        if (course != null && !course.isEmpty()) {
            coursesTaught.add(course);
        }
    }

    public List<String> getCoursesTaught() {
        return new ArrayList<>(coursesTaught);
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
