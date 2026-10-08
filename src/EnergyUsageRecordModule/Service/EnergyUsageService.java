package EnergyUsageRecordModule.Service;

import ApplianceModule.entity.Appliance;
import EnergyUsageRecordModule.entity.EnergyUsageRecord;
import EnergyUsageRecordModule.Utilities.UsageCalculator;

import java.util.ArrayList;

// Service module for managing energy usage records
public class EnergyUsageService {

    private ArrayList<EnergyUsageRecord> records = new ArrayList<>(); // Stores all usage records

    // Add a new usage record for a given appliance
    public void addUsageRecord(Appliance appliance, String date, double hoursUsed) {

        // Calculate energy consumed using utility
        double energyConsumed = UsageCalculator.calculateEnergy(
                appliance.getPower(),
                hoursUsed
        );

        // Create a new EnergyUsageRecord object
        EnergyUsageRecord record = new EnergyUsageRecord(
                appliance,
                date,
                hoursUsed,
                energyConsumed
        );

        // Store the record
        records.add(record);
    }

    // Return all usage records
    public ArrayList<EnergyUsageRecord> getAllRecords() {
        return records;
    }

    // Calculate total energy consumed across all records
    public double calculateTotalUsage() {
        double total = 0;

        for (EnergyUsageRecord record : records) {
            total += record.getEnergyConsumed();
        }

        return total;
    }

    // Calculate average energy usage using utility
    public double calculateAverageUsage() {
        double total = calculateTotalUsage();

        // Call utility to calculate average
        return UsageCalculator.calculateAverage(total, records.size());
    }
}