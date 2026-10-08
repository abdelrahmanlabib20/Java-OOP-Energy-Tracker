package ApplianceModule.entity;
// Represents a cooling appliance
public class CoolingAppliance extends Appliance {

    // Type of cooling appliance
    private String coolingType;

    // Constructor to initialize cooling appliance
    public CoolingAppliance(String name, double powerWatts, double hoursPerDay, String coolingType) {
        super(name, powerWatts, hoursPerDay);
        this.coolingType = coolingType;
    }

    // Returns the type of cooling appliance
    public String getCoolingType() {
        return coolingType;
    }

    // Calculates daily energy consumption in kWh

    @Override
    public double calculateEnergyConsumption() {
        return (getPower() * getHoursUsed()) / 1000.0;
    }
    // Returns string representation including cooling type

    @Override
    public String toString() {
        return "Cooling Appliance - " + super.toString() +
                ", Cooling Type: " + coolingType;
    }
}