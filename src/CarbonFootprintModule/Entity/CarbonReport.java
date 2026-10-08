package CarbonFootprintModule.Entity;

// Represents the carbon footprint report for household appliances
public class CarbonReport {

    private double energyUsed;        // Total energy consumed (kWh)
    private double carbonEmission;    // Calculated CO2 emission (kg)
    private String emissionLevel;     // Low, Moderate, or High emission level
    private String recommendation;    // Advice to reduce carbon footprint

    // Constructor initializes the total energy used
    public CarbonReport(double energyUsed) {
        this.energyUsed = energyUsed;
    }

    // Getter and setter for energy used
    public double getEnergyUsed() {
        return energyUsed;
    }

    public void setEnergyUsed(double energyUsed) {
        this.energyUsed = energyUsed;
    }

    // Getter and setter for carbon emission
    public double getCarbonEmission() {
        return carbonEmission;
    }

    public void setCarbonEmission(double carbonEmission) {
        this.carbonEmission = carbonEmission;
    }

    // Getter and setter for emission level
    public String getEmissionLevel() {
        return emissionLevel;
    }

    public void setEmissionLevel(String emissionLevel) {
        this.emissionLevel = emissionLevel;
    }

    // Getter and setter for recommendation
    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    // Returns a formatted string of the carbon report
    @Override
    public String toString() {
        return "\nEnergy Used: " + energyUsed + " kWh\n"
                + "CO2 Emission: " + carbonEmission + " kg\n"
                + "Emission Level: " + emissionLevel + "\n"
                + "Recommendation: " + recommendation;
    }
}