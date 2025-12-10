using System;

namespace EmployeeManagementSystemCSharp.EmploymentTypes
{
    public abstract class EmploymentType
    {
        public double BaseRate { get; protected set; }

        public int VacationDays { get; protected set; }

        protected EmploymentType(double baseRate, int vacationDays)
        {
            if (baseRate < 0)
            {
                throw new ArgumentOutOfRangeException(nameof(baseRate), "Base rate cannot be negative.");
            }

            BaseRate = baseRate;
            VacationDays = vacationDays;
        }

        public abstract double CalculateMonthlyPay();
    }
}
