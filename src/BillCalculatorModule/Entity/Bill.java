package BillCalculatorModule.Entity;

// Represents a Bill with energy usage and cost details
public class Bill {

    // Input values
    private double powerWatts;
    private double hoursPerDay;
    private int days;
    private double pricePerKWh;
    // Calculated values
    private double dailyEnergy;
    private double monthlyEnergy;
    private double totalBill;

    // Constructor to initialize input values
    public Bill(double powerWatts, double hoursPerDay,
                int days, double pricePerKWh) {


        this.powerWatts = powerWatts;
        this.hoursPerDay = hoursPerDay;
        this.days = days;
        this.pricePerKWh = pricePerKWh;

    }

    // Getters and setters for input values
    public double getPowerWatts() {

        return powerWatts;

    }
    public void setPowerWatts(double powerWatts) {

        this.powerWatts = powerWatts;

    }
    public double getHoursPerDay() {

        return hoursPerDay;

    }
    public void setHoursPerDay(double hoursPerDay) {

        this.hoursPerDay = hoursPerDay;

    }
    public int getDays() {

        return days;

    }
    public void setDays(int days) {

        this.days = days;

    }
    public double getPricePerKWh() {

        return pricePerKWh;

    }
    public void setPricePerKWh(double pricePerKWh) {

        this.pricePerKWh = pricePerKWh;

    }
    // Getters and setters for calculated values
    public double getDailyEnergy() {

        return dailyEnergy;

    }


    public void setDailyEnergy(double dailyEnergy) {

        this.dailyEnergy = dailyEnergy;

    }



    public double getMonthlyEnergy() {

        return monthlyEnergy;

    }


    public void setMonthlyEnergy(double monthlyEnergy) {

        this.monthlyEnergy = monthlyEnergy;

    }



    public double getTotalBill() {

        return totalBill;

    }


    public void setTotalBill(double totalBill) {

        this.totalBill = totalBill;

    }



    @Override
    public String toString() {


        return "Bill Report\n" +
                "Daily Energy: " + dailyEnergy + " kWh\n" +
                "Monthly Energy: " + monthlyEnergy + " kWh\n" +
                "Total Bill: RM " + totalBill;


    }

}