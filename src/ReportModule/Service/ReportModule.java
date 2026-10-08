
package ReportModule.Service;

import ApplianceModule.Service.ApplianceService;
import ApplianceModule.entity.Appliance;
import ReportModule.Entity.EnergyReport;

// Service module that generates energy reports based on appliances
public class ReportModule {
    private ApplianceService applianceService;
    // Constructor receives the appliance service
    public ReportModule(ApplianceService applianceService){
        this.applianceService = applianceService;
    }

    // Generate an energy report given the price per kWh
    public EnergyReport generateReport(double pricePerKWh){

        // Calculate total energy consumption of all appliances
        double totalConsumption = applianceService.calculateTotalConsumption();

        // Calculate average energy consumption
        double averageConsumption = applianceService.calculateAverageConsumption();

        // Calculate estimated cost based on total consumption and price per kWh
        double estimatedCost = totalConsumption * pricePerKWh;

        // Identify the appliance with the highest energy consumption
        Appliance highestConsumer = applianceService.getHighestConsumptionAppliance();

        // Return a new EnergyReport object with all calculated values
        return new EnergyReport(
                totalConsumption,
                averageConsumption,
                estimatedCost,
                highestConsumer
        );
    }
}