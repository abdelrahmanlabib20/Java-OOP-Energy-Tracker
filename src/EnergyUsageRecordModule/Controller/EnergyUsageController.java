package EnergyUsageRecordModule.Controller;

import ApplianceModule.Service.ApplianceService;
import ApplianceModule.entity.Appliance;
import EnergyUsageRecordModule.Service.EnergyUsageService;
import EnergyUsageRecordModule.view.EnergyUsageView;

// Controller for handling energy usage recording and reporting
public class EnergyUsageController {

    private EnergyUsageView energyUsageView;       // View to interact with user
    private EnergyUsageService energyUsageService; // Service to handle business logic
    private ApplianceService applianceService;     // Service to access appliances

    // Constructor initializes controller with required services and view
    public EnergyUsageController(
            EnergyUsageView energyUsageView,
            EnergyUsageService energyUsageService,
            ApplianceService applianceService) {

        this.energyUsageView = energyUsageView;
        this.energyUsageService = energyUsageService;
        this.applianceService = applianceService;
    }

    // Record usage for a specific appliance
    public void recordEnergyUsage() {

        // Ask user for appliance name
        String applianceName = energyUsageView.getApplianceName();

        // Find appliance by name
        Appliance appliance = findApplianceByName(applianceName);

        // If not found, show error and exit
        if (appliance == null) {
            energyUsageView.showMessage("Appliance not found. Please add the appliance first.");
            return;
        }

        // Get hours used from user
        double hoursUsed = energyUsageView.getHoursUsed();

        // Add usage record via service
        energyUsageService.addUsageRecord(appliance, "Today", hoursUsed);

        // Confirm to user
        energyUsageView.showMessage("Energy usage recorded successfully.");
    }

    // Display all recorded energy usage and summary
    public void viewUsageRecords() {

        // Display individual records
        energyUsageView.displayUsageRecords(energyUsageService.getAllRecords());

        // Calculate total and average energy usage
        double totalEnergy = energyUsageService.calculateTotalUsage();
        double averageEnergy = energyUsageService.calculateAverageUsage();

        // Display summary to user
        energyUsageView.displayUsageSummary(totalEnergy, averageEnergy);
    }

    // Helper to find appliance by name
    private Appliance findApplianceByName(String applianceName) {

        for (Appliance appliance : applianceService.getAllAppliances()) {
            if (appliance.getName().equalsIgnoreCase(applianceName)) {
                return appliance;
            }
        }

        return null; // Not found
    }

}