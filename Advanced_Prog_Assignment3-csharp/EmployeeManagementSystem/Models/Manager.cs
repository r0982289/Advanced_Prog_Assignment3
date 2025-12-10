using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System;
using System.Collections.Generic;
using EmployeeManagementSystemCSharp.Exceptions;
using EmployeeManagementSystemCSharp.EmploymentTypes;

namespace EmployeeManagementSystemCSharp.Models
{
    public class Manager : Employee
    {
        private readonly List<Employee> _teamMembers = new List<Employee>();

        public Manager(string firstName, string lastName, DateTime dateOfBirth,
                       string employeeID, Position position, Manager manager,
                       EmploymentType emplType)
            : base(firstName, lastName, dateOfBirth, employeeID, position, manager, emplType)
        {
        }

        public void addTeamMember(Employee employee)
        {
            try
            {
                if (employee == null)
                {
                    throw new InvalidExceptions("Cannot add null employee");
                }
                _teamMembers.Add(employee);
            }
            catch (InvalidExceptions e)
            {
                System.Console.Error.WriteLine("Error: " + e.Message);
            }
        }

        public void removeTeamMember(Employee employee)
        {
            try
            {
                if (employee == null)
                {
                    throw new InvalidExceptions("Cannot remove null employee");
                }
                _teamMembers.Remove(employee);
            }
            catch (InvalidExceptions e)
            {
                System.Console.Error.WriteLine("Error: " + e.Message);
            }
        }

        public List<Employee> getTeamMembers()
        {
            return new List<Employee>(_teamMembers);
        }

        public override void reportToManager(string message)
        {
            System.Console.WriteLine(
                $"Manager {getFirstName()} {getLastName()} reports: {message}");
        }

        public void conductPerformanceReview(Employee employee)
        {
            try
            {
                if (employee == null)
                {
                    throw new InvalidExceptions("Cannot review null employee");
                }

                System.Console.WriteLine(
                    "Manager " + getFirstName() + " " + getLastName() +
                    " is conducting a performance review for " +
                    employee.getFirstName() + " " + employee.getLastName() + ".");
            }
            catch (InvalidExceptions e)
            {
                System.Console.Error.WriteLine("Error: " + e.Message);
            }
        }
    }
}
