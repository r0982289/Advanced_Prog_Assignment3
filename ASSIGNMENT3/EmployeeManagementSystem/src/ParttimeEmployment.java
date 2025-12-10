import exceptions.*;

public class ParttimeEmployment implements EmploymentType {
    private double hourlyRate;
    private int hoursPerWeek;

    public ParttimeEmployment(double hourlyRate, int hoursPerWeek) {
        try {
            if (hourlyRate <= 0) {
                throw new InvalidExceptions("Hourly rate must be greater than 0");
            }
            if (hoursPerWeek <= 0 || hoursPerWeek > 40) {
                throw new InvalidExceptions("Hours per week must be between 1 and 40");
            }
            
            this.hourlyRate = hourlyRate;
            this.hoursPerWeek = hoursPerWeek;
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
            // Set defaults if invalid
            this.hourlyRate = 15.0;
            this.hoursPerWeek = 20;
        }
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public double getHourlyRate() {  // Fixed return type from int to double
        return hourlyRate;  // Fixed - was returning hoursPerWeek
    }

    @Override
    public double calculatePay() {
        try {
            double pay = hourlyRate * hoursPerWeek * 4;
            if (pay < 0) {
                throw new InvalidExceptions("Calculated pay cannot be negative");
            }
            return pay;
            
        } catch (InvalidExceptions e) {
            System.err.println("Error: " + e.getMessage());
            return 0.0;
        }
    }

    @Override
    public String getEmploymentStatus() {
        return "Part-Time";
    }

    @Override
    public String getPayDetails() {
        return "Hourly Rate: $" + hourlyRate + ", Hours/Week: " + hoursPerWeek;
    }
}