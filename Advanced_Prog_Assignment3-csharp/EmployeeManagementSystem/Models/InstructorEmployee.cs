using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EmployeeManagementSystemCSharp.Exceptions;
using EmployeeManagementSystemCSharp.EmploymentTypes;

namespace EmployeeManagementSystemCSharp.Models
{
    public class InstructorEmployee : Employee
    {
        private readonly List<string> _coursesTaught = new List<string>();
        private string _specialization;

        public InstructorEmployee(string firstName, string lastName, DateTime dateOfBirth,
                                  string employeeID, Position position, Manager manager,
                                  EmploymentType emplType, string specialization)
            : base(firstName, lastName, dateOfBirth, employeeID, position, manager, emplType)
        {
            try
            {
                if (string.IsNullOrWhiteSpace(specialization))
                {
                    throw new InvalidExceptions("Specialization cannot be empty");
                }
                _specialization = specialization;
            }
            catch (InvalidExceptions e)
            {
                System.Console.Error.WriteLine("Error: " + e.Message);
            }
        }

        public void addCourse(string course)
        {
            try
            {
                if (string.IsNullOrWhiteSpace(course))
                {
                    throw new InvalidExceptions("Course name cannot be empty");
                }
                _coursesTaught.Add(course);
            }
            catch (InvalidExceptions e)
            {
                System.Console.Error.WriteLine("Error: " + e.Message);
            }
        }

        public List<string> getCoursesTaught()
        {
            return new List<string>(_coursesTaught);
        }

        public string getSpecialization()
        {
            return _specialization;
        }

        public void setSpecialization(string specialization)
        {
            try
            {
                if (string.IsNullOrWhiteSpace(specialization))
                {
                    throw new InvalidExceptions("Specialization cannot be empty");
                }
                _specialization = specialization;
            }
            catch (InvalidExceptions e)
            {
                System.Console.Error.WriteLine("Error: " + e.Message);
            }
        }

        public override void reportToManager(string message)
        {
            System.Console.WriteLine(
                $"Instructor {getFirstName()} {getLastName()} reports to manager: {message}");
        }
    }
}
