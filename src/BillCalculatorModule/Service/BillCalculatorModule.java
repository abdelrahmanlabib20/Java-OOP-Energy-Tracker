package BillCalculatorModule.Service;

import BillCalculatorModule.Entity.Bill;

public class BillCalculatorModule {

    // Calculate daily energy consumption in kWh and store it in the Bill
    public double calculateDailyKWh(Bill bill) {
        double daily = (bill.getPowerWatts() * bill.getHoursPerDay()) / 1000;
        bill.setDailyEnergy(daily);  // Save daily consumption in Bill object
        return daily;
    }

    // Calculate monthly energy consumption based on daily kWh and number of days
    public double calculateMonthlyKWh(Bill bill) {
        double monthly = calculateDailyKWh(bill) * bill.getDays(); // Multiply daily by days
        bill.setMonthlyEnergy(monthly);  // Save monthly consumption in Bill object
        return monthly;
    }

    // Calculate total bill cost based on monthly consumption and price per kWh
    public double calculateBill(Bill bill) {
        double cost = calculateMonthlyKWh(bill) * bill.getPricePerKWh(); // Multiply by unit price
        bill.setTotalBill(cost);  // Save total bill in Bill object
        return cost;
    }
}