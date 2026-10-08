package EnergyUsageRecordModule.entity;

import ApplianceModule.entity.Appliance;

// Entity class representing a single energy usage record for an appliance
public class EnergyUsageRecord {

    private Appliance appliance;       // Appliance associated with this record
    private String date;               // Date of the record (currently as String)
    private double hoursUsed;          // Number of hours the appliance was used
    private double energyConsumed;     // Energy consumed in kWh

    // Constructor to initialize all fields of the record
    public EnergyUsageRecord(Appliance appliance, String date, double hoursUsed, double energyConsumed) {
        this.appliance = appliance;
        this.date = date;
        this.hoursUsed = hoursUsed;
        this.energyConsumed = energyConsumed;
    }

    // Getter for the appliance
    public Appliance getAppliance() {
        return appliance;
    }

    // Getter for energy consumed
    public double getEnergyConsumed() {
        return energyConsumed;
    }

    // Getter for hours used
    public double getHoursUsed() {
        return hoursUsed;
    }

    // Provides a readable summary of the energy usage record
    @Override
    public String toString() {
        return "Appliance: " + appliance.getName()
                + "\nHours Used: " + hoursUsed
                + "\nEnergy Consumed: " + energyConsumed + " kWh";
    }

}