import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import exceptions.*;

public class PayrollEmployee extends Employee {

    private List<String> certifications = new ArrayList<>();

    public PayrollEmployee(String firstName, String lastName, Date dateOfBirth,
            String employeeID, Position position, Manager manager,
            EmploymentType emplType) {
        super(firstName, lastName, dateOfBirth, employeeID, position, manager, emplType);
    }

    public void processPayroll() {
        try {
            System.out.println("Processing payroll for all employees.");
            
        } catch (Exception e) {
            System.err.println("Error processing payroll: " + e.getMessage());
        }
    }

    public int getEmployeesManaged() {
        try {
            if (getManager() != null && getManager().getTeamMembers() != null) {
                return getManager().getTeamMembers().size();
            }
            return 0;
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            return 0;
        }
    }

    public void addCertification(String cert) {
        try {
            if (cert == null || cert.trim().isEmpty()) {
                throw new InvalidExceptions("Certification cannot be empty");
            }
            certifications.add(cert);
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public List<String> getCertifications() {
        return new ArrayList<>(certifications);
    }
}