using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using EmployeeManagementSystemCSharp.Models;
using EmployeeManagementSystemCSharp.EmploymentTypes;
using EmployeeManagementSystemCSharp.Exceptions;

namespace EmployeeManagementSystemCSharp.Services
{
    /// <summary>
    /// provides business rules for validating employees
    /// </summary>
    public class EmployeeManagerSystem
    {
        /// <summary>
        /// Validates employment type
        /// </summary>
        /// <param name="employee">The employee to validate.</param>
        public void validateEmploymentType(Employee employee)
        {
            try
            {
                if (employee == null)
                {
                    throw new InvalidExceptions("Cannot validate a null employee.");
                }

                EmploymentType employmentType = employee.getEmplType();
                if (employmentType == null)
                {
                    throw new InvalidExceptions("Employment type cannot be null.");
                }

                if (employee is PayrollEmployee && employmentType is ParttimeEmployment)
                {
                    throw new InvalidExceptions(
                        "Invalid employment type: Payroll employees must be full-time.");
                }

                Console.WriteLine(
                    $"Employment type for employee {employee.getEmployeeID()} is valid.");
            }
            catch (InvalidExceptions e)
            {
                Console.Error.WriteLine("Validation error: " + e.Message);
            }
        }
    }
}
