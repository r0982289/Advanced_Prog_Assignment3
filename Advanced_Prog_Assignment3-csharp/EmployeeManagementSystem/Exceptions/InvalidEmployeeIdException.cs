using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeManagementSystemCSharp.Exceptions
{
    public class InvalidEmployeeIdException : Exception
    {
        public InvalidEmployeeIdException(string message)
            : base(message)
        {
        }

        public static void validateEmployeeID(string employeeID)
        {
            try
            {
                if (employeeID == null)
                {
                    throw new InvalidEmployeeIdException("Employee ID cannot be null.");
                }

                if (employeeID.Length < 5)
                {
                    throw new InvalidEmployeeIdException("Employee ID must be at least 5 characters long.");
                }

                Console.WriteLine("✓ Employee ID is valid: " + employeeID);
            }
            catch (InvalidEmployeeIdException e)
            {
                Console.Error.WriteLine("Error: " + e.Message);
            }
        }
    }
}
