import exceptions.*;

public class FulltimeEmployment implements EmploymentType {
    private double annualSalary;
    private int vacationDays;

    public FulltimeEmployment(double annualSalary, int vacationDays) {
        try {
            if (annualSalary <= 0) {
                throw new InvalidExceptions("Annual salary must be greater than 0");
            }
            if (vacationDays < 0 || vacationDays > 30) {
                throw new InvalidExceptions("Vacation days must be between 0 and 30");
            }
            
            this.annualSalary = annualSalary;
            this.vacationDays = vacationDays;
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
            // Set defaults if invalid
            this.annualSalary = 50000;
            this.vacationDays = 15;
        }
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    @Override
    public double calculatePay() {
        try {
            double monthlyPay = (annualSalary / 12) + calculateBenefits() / 12;
            if (monthlyPay < 0) {
                throw new InvalidExceptions("Calculated pay cannot be negative");
            }
            return monthlyPay;
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
            return 0.0;
        }
    }

    public double calculateBenefits() {
        try {
            double benefits = annualSalary * 0.2;
            if (benefits < 0) {
                throw new InvalidExceptions("Benefits cannot be negative");
            }
            return benefits;
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
            return 0.0;
        }
    }

    @Override
    public String getEmploymentStatus() {
        return "Full-Time";
    }

    @Override
    public String getPayDetails() {
        return "Salary: $" + annualSalary + ", Benefits: $" + calculateBenefits() +
                ", Vacation Days: " + vacationDays;
    }
}