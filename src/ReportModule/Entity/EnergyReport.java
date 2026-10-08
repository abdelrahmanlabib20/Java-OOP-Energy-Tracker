package ReportModule.Entity;

import ApplianceModule.entity.Appliance;

// Represents the summary of energy consumption for all appliances
public class EnergyReport {

    private double totalConsumption;
    private double averageConsumption;
    private double estimatedCost;
    private Appliance highestConsumer;

    // Constructor to initialize all report fields
    public EnergyReport(
            double totalConsumption,
            double averageConsumption,
            double estimatedCost,
            Appliance highestConsumer) {

        this.totalConsumption = totalConsumption;
        this.averageConsumption = averageConsumption;
        this.estimatedCost = estimatedCost;
        this.highestConsumer = highestConsumer;
    }
    // Get total energy consumed
    public double getTotalConsumption() {
        return totalConsumption;
    }
    // Get average energy consumption
    public double getAverageConsumption() {
        return averageConsumption;
    }
    // Get estimated cost of total energy consumed
    public double getEstimatedCost() {
        return estimatedCost;
    }
    // Get appliance that consumed the most energy
    public Appliance getHighestConsumer() {
        return highestConsumer;
    }
    // Returns a formatted string representation of the report
    @Override
    public String toString() {
        return "===== Energy Report =====\n" +
                "Total Energy Used: " + totalConsumption + " kWh\n" +
                "Average Energy Usage: " + averageConsumption + " kWh\n" +
                "Estimated Cost: RM " + estimatedCost + "\n" +
                "Highest Consumer: " + highestConsumer;
    }
}