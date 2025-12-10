import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import exceptions.*;

public class InstructorEmployee extends Employee {

    private List<String> coursesTaught = new ArrayList<>();
    private String specialization;

    public InstructorEmployee(String firstName, String lastName, Date dateOfBirth,
            String employeeID, Position position, Manager manager,
            EmploymentType emplType, String specialization) {
        super(firstName, lastName, dateOfBirth, employeeID, position, manager, emplType);
        
        try {
            if (specialization == null || specialization.trim().isEmpty()) {
                throw new InvalidExceptions("Specialization cannot be empty");
            }
            this.specialization = specialization;
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
            this.specialization = "General";
        }
    }

    public void addCourse(String course) {
        try {
            if (course == null || course.trim().isEmpty()) {
                throw new InvalidExceptions("Course name cannot be empty");
            }
            coursesTaught.add(course);
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public List<String> getCoursesTaught() {
        return new ArrayList<>(coursesTaught);
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        try {
            if (specialization == null || specialization.trim().isEmpty()) {
                throw new InvalidExceptions("Specialization cannot be empty");
            }
            this.specialization = specialization;
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}