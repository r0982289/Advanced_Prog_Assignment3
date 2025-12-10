import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayrollEmployee extends Employee {

    private List<String> certifications = new ArrayList<>();

    public PayrollEmployee(String firstName, String lastName, Date dateOfBirth,
            String employeeID, Position position, Manager manager,
            EmploymentType emplType) {
        super(firstName, lastName, dateOfBirth, employeeID, position, manager, emplType);
    }

    public void processPayroll() {
        System.out.println("Processing payroll for all employees.");
    }

    public int getEmployeesManaged() {
        if (getManager() != null && getManager().getTeamMembers() != null) {
            return getManager().getTeamMembers().size();
        }
        return 0;
    }

    public void addCertification(String cert) {
        if (cert != null && !cert.isEmpty()) {
            certifications.add(cert);
        }
    }

    public List<String> getCertifications() {
        return new ArrayList<>(certifications);
    }
}
