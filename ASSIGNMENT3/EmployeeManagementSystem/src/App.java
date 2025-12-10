import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import exceptions.*;

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

            // Add employees to list
            List<Employee> employees = new ArrayList<>();
            employees.add(mgr);
            employees.add(payrollEmp);
            employees.add(instructorEmp);
            employees.add(itEmp);
            employees.add(adminEmp);

            // Add employees to manager's team
            mgr.addTeamMember(payrollEmp);
            mgr.addTeamMember(instructorEmp);
            mgr.addTeamMember(itEmp);
            mgr.addTeamMember(adminEmp);

            // Employees reporting to manager
            System.out.println("=== Employee Reports ===");
            payrollEmp.reportToManager("Payroll processed successfully.");
            instructorEmp.reportToManager("Completed lecture preparation.");
            itEmp.reportToManager("System maintenance finished.");
            adminEmp.reportToManager("Office supplies ordered.");

            // Test Employee functionality
            System.out.println("\n=== Employee Details ===");
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
            System.out.println("\n=== Pay Calculation ===");
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

            // Test exceptions
            System.out.println("\n=== Testing Exceptions ===");
            testExceptions();

            // Test multithreading
            System.out.println("\n=== Testing File Operations ===");
            testFiles(employees);

            System.out.println("\nAll tests done!");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void testExceptions() {
        // test employee IDs
        System.out.println("\nEmployee ID tests:");
        InvalidEmployeeIdException.validateEmployeeID("E01");
        InvalidEmployeeIdException.validateEmployeeID("EMP001");
        InvalidEmployeeIdException.validateEmployeeID(null);

        // test dates
        System.out.println("\nDate tests:");
        InvalidDateException.DateValidation("32-13-2024");
        InvalidDateException.DateValidation("15-06-1990");
        InvalidDateException.DateValidation("");

        // test salary
        System.out.println("\nSalary tests:");
        InvalidExceptions.salaryValidate(-5000);
        InvalidExceptions.salaryValidate(70000);

        // test name
        System.out.println("\nName tests:");
        InvalidExceptions.nameValidate("");
        InvalidExceptions.nameValidate("John");

        // test division
        System.out.println("\nMath test:");
        try {
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            System.err.println("Error: can't divide by zero");
        }
    }

    private static void testFiles(List<Employee> employees) {
        // write file
        Thread t1 = new Thread(new EmployeeFileHandler(employees, "employees.txt", true));
        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // read file
        Thread t2 = new Thread(new EmployeeFileHandler(null, "employees.txt", false));
        t2.start();
        try {
            t2.join();
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // two threads at once
        Thread t3 = new Thread(new EmployeeFileHandler(employees, "backup1.txt", true));
        Thread t4 = new Thread(new EmployeeFileHandler(employees, "backup2.txt", true));
        t3.start();
        t4.start();
        try {
            t3.join();
            t4.join();
            System.out.println("Backup files saved!");
        } catch (InterruptedException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}