package EnergyAlertModule.Controller;

import ApplianceModule.Service.ApplianceService;
import EnergyAlertModule.Service.EnergyAlertModule;
import ApplianceModule.entity.Appliance;
import EnergyAlertModule.view.EnergyAlertView;

public class EnergyAlertController {

    private EnergyAlertView energyAlertView;
    private ApplianceService applianceService;
    private EnergyAlertModule energyAlertModule;

    // Constructor initializes the controller with view, appliance service, and alert service
    public EnergyAlertController(EnergyAlertView energyAlertView,
                                 ApplianceService applianceService,
                                 EnergyAlertModule energyAlertModule) {
        this.energyAlertView = energyAlertView;
        this.applianceService = applianceService;
        this.energyAlertModule = energyAlertModule;
    }

    // Main method to display daily, monthly, and appliance-specific alerts
    public void viewEnergyAlerts() {

        // Calculate daily and monthly total energy usage
        double dailyUsage = applianceService.calculateTotalConsumption();
        double monthlyUsage = dailyUsage * 30;

        // Get alert messages based on thresholds
        String dailyStatus = energyAlertModule.getDailyStatus(dailyUsage);
        String monthlyStatus = energyAlertModule.getMonthlyStatus(monthlyUsage);

        // Display daily and monthly alerts in view
        energyAlertView.displayDailyAlert(dailyUsage,
                energyAlertModule.getDailyLimitKWh(),
                dailyStatus);

        energyAlertView.displayMonthlyAlert(monthlyUsage,
                energyAlertModule.getMonthlyLimitKWh(),
                monthlyStatus);

        // Identify the appliance with the highest consumption
        Appliance highestAppliance = applianceService.findHighConsumptionAppliance();

        if (highestAppliance == null) {
            energyAlertView.showMessage("No appliance data available for appliance alert.");
        } else {
            // Check individual appliance usage and provide recommendation
            double applianceUsage = highestAppliance.calculateEnergyConsumption();
            String applianceStatus = energyAlertModule.getApplianceStatus(applianceUsage);
            String suggestion = energyAlertModule.giveSuggestion(highestAppliance.getName());

            energyAlertView.displayApplianceAlert(
                    highestAppliance.getName(),
                    applianceUsage,
                    energyAlertModule.getApplianceLimitKWh(),
                    applianceStatus,
                    suggestion
            );
        }
    }
}