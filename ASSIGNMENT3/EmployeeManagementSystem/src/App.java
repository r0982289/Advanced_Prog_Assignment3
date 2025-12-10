import java.util.Date;

public class App {

    public static void main(String[] args) {

        try {
            // Creating Positions & Departments
            Position payrollPos = new Position("Payroll Specialist", Department.PAYROLL);
            Position instructorPos = new Position("Senior Instructor", Department.STAFF);
            Position itPos = new Position("IT Support", Department.IT);
            Position adminPos = new Position("Office Administrator", Department.ADMINISTRATION);
            Position managerPos = new Position("Team Manager", Department.STAFF);

            // creating Employment Types
            EmploymentType fullTime = new FulltimeEmployment(60000, 15);
            EmploymentType partTime = new ParttimeEmployment(30, 20);

            // creating a Manager
            Manager mgr = new Manager("Alice", "Johnson", new Date(),
                    "MGR001", managerPos, null, fullTime);

            // creating Employees
            PayrollEmployee payrollEmp = new PayrollEmployee("Bob", "Smith", new Date(),
                    "EMP001", payrollPos, mgr, fullTime);

            InstructorEmployee instructorEmp = new InstructorEmployee("Carol", "Davis", new Date(),
                    "EMP002", instructorPos, mgr, partTime, "Mathematics");

            ITEmployee itEmp = new ITEmployee("David", "Wilson", new Date(),
                    "EMP003", itPos, mgr, fullTime);

            AdminEmployee adminEmp = new AdminEmployee("Eva", "Brown", new Date(),
                    "EMP004", adminPos, mgr, partTime);

            // Add employees to manager's team
            mgr.addTeamMember(payrollEmp);
            mgr.addTeamMember(instructorEmp);
            mgr.addTeamMember(itEmp);
            mgr.addTeamMember(adminEmp);

            // Employees reporting to manager
            payrollEmp.reportToManager("Payroll processed successfully.");
            instructorEmp.reportToManager("Completed lecture preparation.");
            itEmp.reportToManager("System maintenance finished.");
            adminEmp.reportToManager("Office supplies ordered.");

            // Test Employee-specific functionality
            payrollEmp.addCertification("CPA");
            System.out.println("Payroll certifications: " + payrollEmp.getCertifications());

            instructorEmp.addCourse("Algebra I");
            instructorEmp.addCourse("Calculus II");
            System.out.println("Instructor courses: " + instructorEmp.getCoursesTaught());

            itEmp.addTechnicalSkill("Network Configuration");
            itEmp.addTechnicalSkill("Database Management");
            System.out.println("IT Skills: " + itEmp.getTechnicalSkills());

            adminEmp.addResponsibility("Document Filing");
            adminEmp.addResponsibility("Schedule Meetings");
            System.out.println("Admin Responsibilities: " + adminEmp.getResponsibilities());

            // Test pay calculation
            System.out.println(payrollEmp.getFirstName() + " monthly pay: $" + payrollEmp.getPaid());
            System.out.println(instructorEmp.getFirstName() + " monthly pay: $" + instructorEmp.getPaid());
            System.out.println(itEmp.getFirstName() + " monthly pay: $" + itEmp.getPaid());
            System.out.println(adminEmp.getFirstName() + " monthly pay: $" + adminEmp.getPaid());

            // Validate Employment Types
            EmployeeManagerSystem ems = new EmployeeManagerSystem();
            ems.validateEmploymentType(payrollEmp);
            ems.validateEmploymentType(instructorEmp);
            ems.validateEmploymentType(itEmp);
            ems.validateEmploymentType(adminEmp);

            System.out.println("All employees validated successfully.");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
