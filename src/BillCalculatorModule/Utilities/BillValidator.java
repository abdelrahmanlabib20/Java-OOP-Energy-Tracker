package BillCalculatorModule.Utilities;

public class BillValidator {

    // Validate that power in watts is positive
    public static boolean validatePower(double power) {
        return power > 0;
    }

    // Validate that hours per day is zero or more
    public static boolean validateHours(double hours) {
        return hours >= 0;
    }

    // Validate that number of days is greater than zero
    public static boolean validateDays(int days) {
        return days > 0;
    }

    // Validate that price per kWh is zero or more
    public static boolean validatePrice(double price) {
        return price >= 0;
    }
}