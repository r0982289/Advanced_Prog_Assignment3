using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EmployeeManagementSystemCSharp.Exceptions;

namespace EmployeeManagementSystemCSharp.Models
{
    public class Position
    {
        private string _positionName;
        private Department _department;

        public Position(string positionName, Department department)
        {
            try
            {
                if (string.IsNullOrWhiteSpace(positionName))
                {
                    throw new InvalidExceptions("Position name cannot be empty");
                }
                // Department is an enum, so it cannot be null in C#, but we keep the logic close to Java.
                _positionName = positionName;
                _department = department;
            }
            catch (InvalidExceptions e)
            {
                System.Console.Error.WriteLine("Error: " + e.Message);
            }
        }

        public string getPositionName()
        {
            return _positionName;
        }

        public Department getDepartment()
        {
            return _department;
        }

        public void setDepartment(Department department)
        {
            try
            {
                // Again, mostly for parity with the Java semantics.
                _department = department;
            }
            catch (InvalidExceptions e)
            {
                System.Console.Error.WriteLine("Error: " + e.Message);
            }
        }

        public void setPositionName(string positionName)
        {
            try
            {
                if (string.IsNullOrWhiteSpace(positionName))
                {
                    throw new InvalidExceptions("Position name cannot be empty");
                }
                _positionName = positionName;
            }
            catch (InvalidExceptions e)
            {
                System.Console.Error.WriteLine("Error: " + e.Message);
            }
        }

        public override string ToString()
        {
            return $"{_positionName} ({_department})";
        }
    }
}
