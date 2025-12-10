public class ParttimeEmployment implements EmploymentType {
    private double hourlyRate;
    private int hoursPerWeek;

    public ParttimeEmployment(double hourlyRate, int hoursPerWeek) {
        this.hourlyRate = hourlyRate;
        this.hoursPerWeek = hoursPerWeek;
    }

    public int getHoursPerWeek() {
        return hoursPerWeek;
    }

    public int getHourlyRate() {
        return hoursPerWeek;
    }

    @Override
    public double calculatePay() {
        return hourlyRate * hoursPerWeek * 4; // approx monthly pay
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
