public class FulltimeEmployment implements EmploymentType {
    private double annualSalary;
    private int vacationDays;

    public FulltimeEmployment(double annualSalary, int vacationDays) {
        this.annualSalary = annualSalary;
        this.vacationDays = vacationDays;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    public double getAnnualSalary() {
        return annualSalary;
    }

    @Override
    public double calculatePay() {
        return (annualSalary / 12) + calculateBenefits() / 12;
    }

    public double calculateBenefits() {
        // example benefit: 20% of salary
        return annualSalary * 0.2;
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
