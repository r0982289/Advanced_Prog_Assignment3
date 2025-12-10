using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System;
using EmployeeManagementSystemCSharp.Exceptions;
using EmployeeManagementSystemCSharp.EmploymentTypes;
using EmployeeManagementSystemCSharp.Models;

namespace EmployeeManagementSystemCSharp.Models
{
    public class Employee
    {
        private string _firstName;
        private string _lastName;
        private DateTime _dateOfBirth;
        private string _employeeID;
        private Position _position;
        private Manager _manager;
        private EmploymentType _emplType;

        public Employee(string firstName, string lastName, DateTime dateOfBirth,
                        string employeeID, Position position,
                        Manager manager, EmploymentType emplType)
        {
            try
            {
                if (string.IsNullOrWhiteSpace(firstName))
                {
                    throw new InvalidExceptions("First name cannot be null or empty.");
                }
                if (string.IsNullOrWhiteSpace(lastName))
                {
                    throw new InvalidExceptions("Last name cannot be null or empty.");
                }
                if (string.IsNullOrWhiteSpace(employeeID))
                {
                    throw new InvalidExceptions("Employee ID cannot be null or empty.");
                }
                if (position == null)
                {
                    throw new InvalidExceptions("Position cannot be null.");
                }
                if (emplType == null)
                {
                    throw new InvalidExceptions("Employment type cannot be null.");
                }

                _firstName = firstName;
                _lastName = lastName;
                _dateOfBirth = dateOfBirth;
                _employeeID = employeeID;
                _position = position;
                _manager = manager;
                _emplType = emplType;
            }
            catch (InvalidExceptions e)
            {
                System.Console.Error.WriteLine("Error: " + e.Message);
            }
        }

        public string getFirstName()
        {
            return _firstName;
        }

        public string getLastName()
        {
            return _lastName;
        }

        public string getEmployeeID()
        {
            return _employeeID;
        }

        public Position getPosition()
        {
            return _position;
        }

        public Department getDepartment()
        {
            return _position != null ? _position.getDepartment() : default;
        }

        public EmploymentType getEmplType()
        {
            return _emplType;
        }

        public DateTime getDateOfBirth()
        {
            return _dateOfBirth;
        }

        public void setManager(Manager manager)
        {
            try
            {
                _manager = manager;
            }
            catch (InvalidExceptions e)
            {
                System.Console.Error.WriteLine("Error: " + e.Message);
            }
        }

        public void setPosition(Position position)
        {
            try
            {
                if (position == null)
                {
                    throw new InvalidExceptions("Position cannot be null");
                }
                _position = position;
            }
            catch (InvalidExceptions e)
            {
                System.Console.Error.WriteLine("Error: " + e.Message);
            }
        }

        public void setEmplType(EmploymentType emplType)
        {
            try
            {
                if (emplType == null)
                {
                    throw new InvalidExceptions("Employment type cannot be null");
                }
                _emplType = emplType;
            }
            catch (InvalidExceptions e)
            {
                System.Console.Error.WriteLine("Error: " + e.Message);
            }
        }

        public virtual void reportToManager(string message)
        {
            if (_manager == null)
            {
                System.Console.WriteLine($"{_firstName} {_lastName} has no manager assigned yet.");
                return;
            }

            System.Console.WriteLine(
                $"{_firstName} {_lastName} reports to manager {_manager.getFirstName()} {_manager.getLastName()}: {message}");
        }

        public double getPaid()
        {
            if (_emplType == null)
            {
                return 0;
            }
            return _emplType.CalculateMonthlyPay();
        }

        public double getPaid(double bonusAmount)
        {
            if (_emplType == null)
            {
                return bonusAmount;
            }
            return _emplType.CalculateMonthlyPay() + bonusAmount;
        }

        public override string ToString()
        {
            return $"{_employeeID}: {_firstName} {_lastName} - {_position}";
        }
    }
}
