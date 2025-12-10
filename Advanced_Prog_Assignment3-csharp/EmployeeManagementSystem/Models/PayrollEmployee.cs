using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EmployeeManagementSystemCSharp.Exceptions;
using EmployeeManagementSystemCSharp.EmploymentTypes;

namespace EmployeeManagementSystemCSharp.Models
{
    public class PayrollEmployee : Employee
    {
        private readonly List<string> _certifications = new List<string>();

        public PayrollEmployee(string firstName, string lastName, DateTime dateOfBirth,
                               string employeeID, Position position, Manager manager,
                               EmploymentType emplType)
            : base(firstName, lastName, dateOfBirth, employeeID, position, manager, emplType)
        {
        }

        public void processPayroll()
        {
            System.Console.WriteLine(
                $"Payroll employee {getFirstName()} {getLastName()} is processing payroll.");
        }

        public void addCertification(string cert)
        {
            try
            {
                if (string.IsNullOrWhiteSpace(cert))
                {
                    throw new InvalidExceptions("Certification cannot be empty");
                }
                _certifications.Add(cert);
            }
            catch (InvalidExceptions e)
            {
                System.Console.Error.WriteLine("Error: " + e.Message);
            }
        }

        public List<string> getCertifications()
        {
            return new List<string>(_certifications);
        }

        public override void reportToManager(string message)
        {
            System.Console.WriteLine(
                $"Payroll employee {getFirstName()} {getLastName()} reports to manager: {message}");
        }
    }
}
