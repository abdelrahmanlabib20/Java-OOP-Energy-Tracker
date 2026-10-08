package EnergyUsageRecordModule.Utilities;

// Utility class for energy calculations
public class UsageCalculator {

    // Calculate energy consumed based on power (Watts) and hours used
    public static double calculateEnergy(double power, double hoursUsed) {
        return (power * hoursUsed) / 1000.0; // Convert to kWh
    }

    // Calculate average energy usage across multiple records
    public static double calculateAverage(double totalEnergy, int numberOfRecords) {
        if (numberOfRecords == 0) {
            return 0; // Avoid division by zero
        }
        return totalEnergy / numberOfRecords;
    }
}