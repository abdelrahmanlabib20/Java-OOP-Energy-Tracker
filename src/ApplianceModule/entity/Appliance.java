package ApplianceModule.entity;

public class Appliance {

    private String name;
    private double power;
    private double hoursUsed;

    // Constructor to initialize the appliance
    public Appliance(String name, double power, double hoursUsed) {
        this.name = name;
        this.power = power;
        this.hoursUsed = hoursUsed;
    }

    public String getName() {
        return name;
    }

    public double getPower() {
        return power;
    }

    public double getHoursUsed() {
        return hoursUsed;
    }

    public void setHoursUsed(double hoursUsed) {
        this.hoursUsed = hoursUsed;
    }

    // Calculates daily energy consumption in kWh
    public double calculateEnergyConsumption() {
        return (power * hoursUsed) / 1000.0;
    }

    // Returns formatted appliance details as a string
    @Override
    public String toString() {
        return "Name: " + name +
                ", Power: " + power + " W" +
                ", Hours Used: " + hoursUsed +
                ", Energy: " + calculateEnergyConsumption() + " kWh";
    }
}