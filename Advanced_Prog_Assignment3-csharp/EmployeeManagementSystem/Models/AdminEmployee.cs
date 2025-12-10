using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EmployeeManagementSystemCSharp.EmploymentTypes;
using EmployeeManagementSystemCSharp.Exceptions;

namespace EmployeeManagementSystemCSharp.Models
{
    public class AdminEmployee : Employee
    {
        private readonly List<string> _responsibilities = new List<string>();

        public AdminEmployee(string firstName, string lastName, DateTime dateOfBirth,
                             string employeeID, Position position, Manager manager,
                             EmploymentType emplType)
            : base(firstName, lastName, dateOfBirth, employeeID, position, manager, emplType)
        {
        }

        public void addResponsibility(string responsibility)
        {
            try
            {
                if (string.IsNullOrWhiteSpace(responsibility))
                {
                    throw new InvalidExceptions("Responsibility cannot be empty");
                }
                _responsibilities.Add(responsibility);
            }
            catch (InvalidExceptions e)
            {
                System.Console.Error.WriteLine("Error: " + e.Message);
            }
        }

        public List<string> getResponsibilities()
        {
            return new List<string>(_responsibilities);
        }

        public override void reportToManager(string message)
        {
            System.Console.WriteLine(
                $"Admin employee {getFirstName()} {getLastName()} reports to manager: {message}");
        }
    }
}
