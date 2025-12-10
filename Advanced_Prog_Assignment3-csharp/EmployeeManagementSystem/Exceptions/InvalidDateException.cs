using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Text.RegularExpressions;

namespace EmployeeManagementSystemCSharp.Exceptions
{
    public class InvalidDateException : Exception
    {
        public InvalidDateException(string message)
            : base(message)
        {
        }

        public static void DateValidation(string date)
        {
            try
            {
                if (date == null || date.Trim().Length == 0)
                {
                    throw new InvalidDateException("Date cannot be null or empty.");
                }

                if (!Regex.IsMatch(date, @"^\d{2}-\d{2}-\d{4}$"))
                {
                    throw new InvalidDateException("Date must be in the format DD-MM-YYYY.");
                }

                string[] parts = date.Split('-');

                int month = int.Parse(parts[1]);
                int day = int.Parse(parts[2]);

                if (month < 1 || month > 12)
                {
                    throw new InvalidDateException("Bad month: " + month);
                }

                if (day < 1 || day > 31)
                {
                    throw new InvalidDateException("Bad day: " + day);
                }
            }
            catch (InvalidDateException e)
            {
                Console.Error.WriteLine("Error: " + e.Message);
            }
        }
    }
}
