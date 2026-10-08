package CarbonFootprintModule.Service;

import ApplianceModule.Service.ApplianceService;
import CarbonFootprintModule.Entity.CarbonReport;
import CarbonFootprintModule.Utilities.CarbonCalculator;

public class CarbonFootprintModule {

    private double emissionFactor;

    // Default constructor sets a baseline emission factor (kg CO2 per kWh)
    public CarbonFootprintModule() {
        emissionFactor = 0.50;
    }


    public CarbonReport analyzeCarbon(ApplianceService applianceService) {

        // 1. Get total energy used from appliances
        double energyUsage = applianceService.calculateTotalConsumption();

        // 2. Calculate the carbon emission using utility method
        double emission = CarbonCalculator.calculateEmission(energyUsage, emissionFactor);

        // 3. Create the report object with total energy
        CarbonReport report = new CarbonReport(energyUsage);

        // 4. Set the carbon emission in the report
        report.setCarbonEmission(emission);

        // 5. Determine the emission level using the utility
        report.setEmissionLevel(CarbonCalculator.getEmissionLevel(emission));

        // 6. Generate a recommendation based on the emission
        report.setRecommendation(CarbonCalculator.getRecommendation(emission));

        // 7. Return the completed report
        return report;
    }
}