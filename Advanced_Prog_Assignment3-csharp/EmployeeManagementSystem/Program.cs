using System;
using System.Collections.Generic;
using System.Threading;
using EmployeeManagementSystemCSharp.Models;
using EmployeeManagementSystemCSharp.EmploymentTypes;
using EmployeeManagementSystemCSharp.Exceptions;
using EmployeeManagementSystemCSharp.Services;

namespace EmployeeManagementSystemCSharp
{
    internal class Program
    {
        static void Main(string[] args)
        {
            try
            {
                //  creating positions/departments
                Position payrollPos = new Position("Payroll Specialist", Department.PAYROLL);
                Position instructorPos = new Position("Senior Instructor", Department.STAFF);
                Position itPos = new Position("IT Support", Department.IT);
                Position adminPos = new Position("Office Administrator", Department.ADMINISTRATION);
                Position managerPos = new Position("Team Manager", Department.STAFF);

                // creating employment types
                EmploymentType fullTime = new FulltimeEmployment(60000, 15);
                EmploymentType partTime = new ParttimeEmployment(30, 20);

                // create manager
                Manager mgr = new Manager("Alice", "Johnson", DateTime.Now,
                    "MGR001", managerPos, null, fullTime);

                // create employees
                PayrollEmployee payrollEmp = new PayrollEmployee("Bob", "Smith", DateTime.Now,
                    "EMP001", payrollPos, mgr, fullTime);

                InstructorEmployee instructorEmp = new InstructorEmployee("Carol", "Davis", DateTime.Now,
                    "EMP002", instructorPos, mgr, partTime, "Mathematics");

                ITEmployee itEmp = new ITEmployee("David", "Wilson", DateTime.Now,
                    "EMP003", itPos, mgr, fullTime);

                AdminEmployee adminEmp = new AdminEmployee("Eva", "Brown", DateTime.Now,
                    "EMP004", adminPos, mgr, partTime);

                // add employees to list
                List<Employee> employees = new List<Employee>
                {
                    mgr,
                    payrollEmp,
                    instructorEmp,
                    itEmp,
                    adminEmp
                };

                // add employees to manager's team
                mgr.addTeamMember(payrollEmp);
                mgr.addTeamMember(instructorEmp);
                mgr.addTeamMember(itEmp);
                mgr.addTeamMember(adminEmp);

                //eEmployees reporting to manager
                Console.WriteLine("=== Employee Reports ===");
                payrollEmp.reportToManager("Payroll processed successfully.");
                instructorEmp.reportToManager("Completed lecture preparation.");
                itEmp.reportToManager("System maintenance finished.");
                adminEmp.reportToManager("Office supplies ordered.");

                // test employee functionality
                Console.WriteLine("\n=== Employee Details ===");
                payrollEmp.addCertification("CPA");
                Console.WriteLine("Payroll certifications: " +
                                  string.Join(", ", payrollEmp.getCertifications()));

                instructorEmp.addCourse("Algebra I");
                instructorEmp.addCourse("Calculus II");
                Console.WriteLine("Instructor courses: " +
                                  string.Join(", ", instructorEmp.getCoursesTaught()));

                itEmp.addTechnicalSkill("Network Configuration");
                itEmp.addTechnicalSkill("Database Management");
                Console.WriteLine("IT Skills: " +
                                  string.Join(", ", itEmp.getTechnicalSkills()));

                adminEmp.addResponsibility("Document Filing");
                adminEmp.addResponsibility("Schedule Meetings");
                Console.WriteLine("Admin Responsibilities: " +
                                  string.Join(", ", adminEmp.getResponsibilities()));

                // test pay calculation
                Console.WriteLine("\n=== Pay Calculation ===");
                Console.WriteLine(payrollEmp.getFirstName() + " monthly pay: $" + payrollEmp.getPaid());
                Console.WriteLine(instructorEmp.getFirstName() + " monthly pay: $" + instructorEmp.getPaid());
                Console.WriteLine(itEmp.getFirstName() + " monthly pay: $" + itEmp.getPaid());
                Console.WriteLine(adminEmp.getFirstName() + " monthly pay: $" + adminEmp.getPaid());

                // validate employment types
                EmployeeManagerSystem ems = new EmployeeManagerSystem();
                ems.validateEmploymentType(payrollEmp);
                ems.validateEmploymentType(instructorEmp);
                ems.validateEmploymentType(itEmp);
                ems.validateEmploymentType(adminEmp);

                Console.WriteLine("All employees validated successfully.");

                // test exceptions
                Console.WriteLine("\n=== Testing Exceptions ===");
                testExceptions();

                // test multithreading and file operations
                Console.WriteLine("\n=== Testing File Operations ===");
                testFiles(employees);

                Console.WriteLine("\nAll tests done!");
            }
            catch (Exception e)
            {
                Console.Error.WriteLine("Error: " + e.Message);
            }
        }

        /// <summary>
        /// runs a set of tests
        /// </summary>
        private static void testExceptions()
        {
            // test employee IDs
            Console.WriteLine("\nEmployee ID tests:");
            InvalidEmployeeIdException.validateEmployeeID("E01");
            InvalidEmployeeIdException.validateEmployeeID("EMP001");
            InvalidEmployeeIdException.validateEmployeeID(null);

            // test dates
            Console.WriteLine("\nDate tests:");
            InvalidDateException.DateValidation("32-13-2024");
            InvalidDateException.DateValidation("15-06-1990");
            InvalidDateException.DateValidation("");

            // test salary
            Console.WriteLine("\nSalary tests:");
            InvalidExceptions.salaryValidate(-5000);
            InvalidExceptions.salaryValidate(70000);

            // test name
            Console.WriteLine("\nName tests:");
            InvalidExceptions.nameValidate("");
            InvalidExceptions.nameValidate("John");
        }

        /// <summary>
        /// runs operations in multiple threads
        /// </summary>
        private static void testFiles(List<Employee> employees)
        {
            // write file in one thread
            Thread t1 = new Thread(() =>
            {
                EmployeeFileHandler handler = new EmployeeFileHandler(employees, "employees.txt", true);
                handler.Run();
            });

            t1.Start();
            try
            {
                t1.Join();
            }
            catch (ThreadInterruptedException e)
            {
                Console.WriteLine("Error: " + e.Message);
            }

            // read file in another thread
            Thread t2 = new Thread(() =>
            {
                EmployeeFileHandler handler = new EmployeeFileHandler(null, "employees.txt", false);
                handler.Run();
            });

            t2.Start();
            try
            {
                t2.Join();
            }
            catch (ThreadInterruptedException e)
            {
                Console.WriteLine("Error: " + e.Message);
            }

            // two threads writing at same time
            Thread t3 = new Thread(() =>
            {
                EmployeeFileHandler handler = new EmployeeFileHandler(employees, "backup1.txt", true);
                handler.Run();
            });

            Thread t4 = new Thread(() =>
            {
                EmployeeFileHandler handler = new EmployeeFileHandler(employees, "backup2.txt", true);
                handler.Run();
            });

            t3.Start();
            t4.Start();

            try
            {
                t3.Join();
                t4.Join();
                Console.WriteLine("Backup files saved!");
            }
            catch (ThreadInterruptedException e)
            {
                Console.WriteLine("Error: " + e.Message);
            }
        }
    }
}
