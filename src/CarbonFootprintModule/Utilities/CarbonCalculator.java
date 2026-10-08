package CarbonFootprintModule.Utilities;

public class CarbonCalculator {

    // Calculate CO2 emission from energy usage
    public static double calculateEmission(double energyUsage, double emissionFactor) {
        return energyUsage * emissionFactor;
    }

    // Return emission level based on CO2 value
    public static String getEmissionLevel(double emission) {
        if (emission < 20)
            return "Low Carbon Emission";
        else if (emission <= 50)
            return "Moderate Carbon Emission";
        else
            return "High Carbon Emission";
    }

    // Provide recommendation based on emission level
    public static String getRecommendation(double emission) {
        if (emission < 20)
            return "Current energy usage is efficient.";
        else if (emission <= 50)
            return "Consider reducing appliance usage.";
        else
            return "Reduce high consumption appliances.";
    }
}