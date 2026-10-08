package EnergyUsageRecordModule.view;

import EnergyUsageRecordModule.entity.EnergyUsageRecord;

import java.util.ArrayList;
import java.util.Scanner;

// Handles user input and output for energy usage
public class EnergyUsageView {

    private Scanner input = new Scanner(System.in);

    // Get appliance name from user
    public String getApplianceName() {
        System.out.print("Enter appliance name: ");
        return input.nextLine();
    }

    // Get hours used for a specific appliance
    public double getHoursUsed() {
        System.out.print("Enter hours used today: ");
        double hours = input.nextDouble();
        input.nextLine(); // Clear buffer after reading double
        return hours;
    }

    // Display all recorded energy usage entries
    public void displayUsageRecords(ArrayList<EnergyUsageRecord> usageRecords) {
        System.out.println("\n===== Energy Usage Records =====");
        if (usageRecords.isEmpty()) {
            System.out.println("No energy usage records found.");
        } else {
            for (EnergyUsageRecord record : usageRecords) {
                System.out.println(record);
            }
        }
    }

    // Display total and average energy consumption
    public void displayUsageSummary(double totalEnergy, double averageEnergy) {
        System.out.println("\n===== Energy Usage Summary =====");
        System.out.printf("Total Recorded Energy  : %.2f kWh%n", totalEnergy);
        System.out.printf("Average Recorded Energy: %.2f kWh%n", averageEnergy);
    }

    // General method to show any message
    public void showMessage(String message) {
        System.out.println(message);
    }
}