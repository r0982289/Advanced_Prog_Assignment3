using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeManagementSystemCSharp.Exceptions
{
    public class InvalidExceptions : Exception
    {
        public InvalidExceptions(string message)
            : base(message)
        {
        }

        public static void salaryValidate(double salary)
        {
            try
            {
                if (salary < 0)
                {
                    throw new InvalidExceptions("Salary cannot be negative.");
                }
            }
            catch (InvalidExceptions e)
            {
                Console.WriteLine(e.Message);
            }
        }

        public static void nameValidate(string name)
        {
            try
            {
                if (name == null || name.Trim().Length == 0)
                {
                    throw new InvalidExceptions("Name cannot be null or empty.");
                }
            }
            catch (InvalidExceptions e)
            {
                Console.WriteLine(e.Message);
            }
        }
    }
}
