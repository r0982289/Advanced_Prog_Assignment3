using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace EmployeeManagementSystemCSharp.EmploymentTypes
{
    public class ParttimeEmployment : EmploymentType
    {
        public int WeeklyHours { get; private set; }

        public ParttimeEmployment(double hourlyRate, int weeklyHours)
            : base(hourlyRate, 0)
        {
            if (weeklyHours < 0)
            {
                throw new ArgumentOutOfRangeException(nameof(weeklyHours), "Weekly hours cannot be negative.");
            }

            WeeklyHours = weeklyHours;
        }

        public override double CalculateMonthlyPay()
        {
            const int WeeksPerMonth = 4;
            return BaseRate * WeeklyHours * WeeksPerMonth;
        }
    }
}
