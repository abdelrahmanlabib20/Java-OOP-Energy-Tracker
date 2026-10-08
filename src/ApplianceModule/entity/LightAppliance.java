package ApplianceModule.entity;

// Represents a light appliance,
public class LightAppliance extends Appliance {

    // Type of light appliance
    private String lightType;

    // Constructor to initialize light appliance
    public LightAppliance(String name, double power, double hoursUsed, String lightType) {
        super(name, power, hoursUsed); // Call parent constructor
        this.lightType = lightType;
    }

    // Returns the type of light appliance
    public String getLightType() {
        return lightType;
    }

    // Calculates daily energy consumption in kWh
    @Override
    public double calculateEnergyConsumption() {
        return (getPower() * getHoursUsed()) / 1000.0;
    }

    // Returns string representation including light type
    @Override
    public String toString() {
        return "Light Appliance - " + super.toString() +
                ", Light Type: " + lightType;
    }
}