using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EmployeeManagementSystemCSharp.EmploymentTypes;
using EmployeeManagementSystemCSharp.Exceptions;

namespace EmployeeManagementSystemCSharp.Models
{
    public class ITEmployee : Employee
    {
        private readonly List<string> _technicalSkills = new List<string>();

        public ITEmployee(string firstName, string lastName, DateTime dateOfBirth,
                          string employeeID, Position position, Manager manager,
                          EmploymentType emplType)
            : base(firstName, lastName, dateOfBirth, employeeID, position, manager, emplType)
        {
        }

        public void addTechnicalSkill(string skill)
        {
            try
            {
                if (string.IsNullOrWhiteSpace(skill))
                {
                    throw new InvalidExceptions("Technical skill cannot be empty");
                }
                _technicalSkills.Add(skill);
            }
            catch (InvalidExceptions e)
            {
                System.Console.Error.WriteLine("Error: " + e.Message);
            }
        }

        public List<string> getTechnicalSkills()
        {
            return new List<string>(_technicalSkills);
        }

        public override void reportToManager(string message)
        {
            System.Console.WriteLine(
                $"IT employee {getFirstName()} {getLastName()} reports to manager: {message}");
        }
    }
}
