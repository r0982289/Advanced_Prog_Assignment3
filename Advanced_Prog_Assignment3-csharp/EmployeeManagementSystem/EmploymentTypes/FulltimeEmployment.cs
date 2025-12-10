using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeManagementSystemCSharp.EmploymentTypes
{
    public class FulltimeEmployment : EmploymentType
    {
        public FulltimeEmployment(double annualSalary, int vacationDays)
            : base(annualSalary, vacationDays)
        {
        }

        public override double CalculateMonthlyPay()
        {
            const int MonthsPerYear = 12;
            return BaseRate / MonthsPerYear;
        }
    }
}
