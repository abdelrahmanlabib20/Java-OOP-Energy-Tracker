package Menu.Controller;

import ApplianceModule.Controller.ApplianceController;
import ApplianceModule.Service.ApplianceService;
import ApplianceModule.View.ApplianceView;
import BillCalculatorModule.Controller.BillController;
import BillCalculatorModule.Service.BillCalculatorModule;
import BillCalculatorModule.View.BillView;
import CarbonFootprintModule.Controller.CarbonController;
import CarbonFootprintModule.Service.CarbonFootprintModule;
import CarbonFootprintModule.View.CarbonView;
import EnergyAlertModule.Controller.EnergyAlertController;
import EnergyAlertModule.Service.EnergyAlertModule;
import EnergyAlertModule.view.EnergyAlertView;
import EnergyUsageRecordModule.Controller.EnergyUsageController;
import EnergyUsageRecordModule.Service.EnergyUsageService;
import EnergyUsageRecordModule.view.EnergyUsageView;
import ReportModule.Controller.ReportController;
import ReportModule.Service.ReportModule;
import ReportModule.view.ReportView;
import Menu.view.MainMenuView;

// Main controller coordinating all modules and handling the main menu
public class MainController {

    // Main menu view for user interaction
    private MainMenuView mainMenuView = new MainMenuView();

    // Views for all modules
    private ApplianceView applianceView = new ApplianceView();
    private BillView billView = new BillView();
    private ReportView reportView = new ReportView();
    private CarbonView carbonView = new CarbonView();
    private EnergyAlertView energyAlertView = new EnergyAlertView();
    private EnergyUsageView energyUsageView = new EnergyUsageView();

    // Services for all modules
    private ApplianceService applianceService = new ApplianceService();
    private BillCalculatorModule billCalculator = new BillCalculatorModule();
    private ReportModule reportModule = new ReportModule(applianceService);
    private CarbonFootprintModule carbonFootprintModule = new CarbonFootprintModule();
    private EnergyAlertModule energyAlertModule = new EnergyAlertModule();
    private EnergyUsageService energyUsageService = new EnergyUsageService();

    // Controllers for all modules
    private ApplianceController applianceController = new ApplianceController(applianceView, applianceService);
    private BillController billController = new BillController(billView, billCalculator);
    private ReportController reportController = new ReportController(reportView, reportModule);
    private CarbonController carbonController = new CarbonController(carbonView, applianceService, carbonFootprintModule);
    private EnergyAlertController energyAlertController = new EnergyAlertController(energyAlertView, applianceService, energyAlertModule);
    private EnergyUsageController energyUsageController = new EnergyUsageController(energyUsageView, energyUsageService, applianceService);

    // Start the main loop
    public void start() {

        boolean running = true;

        while (running) {

            // Display menu and get user's choice
            int choice = mainMenuView.showMenuAndGetChoice();

            switch (choice) {

                case 1:
                    applianceController.addAppliance(); // Add a new appliance
                    break;

                case 2:
                    applianceController.editAppliance(); // Edit existing appliance
                    break;

                case 3:
                    applianceController.deleteAppliance(); // Delete appliance
                    break;

                case 4:
                    applianceController.viewAllAppliances(); // View all appliances
                    break;

                case 5:
                    applianceController.viewTotalConsumption(); // View total energy consumption
                    break;

                case 6:
                    billController.calculateBill(); // Calculate electricity bill
                    break;

                case 7:
                    reportController.generateSummaryReport(); // Generate summary report
                    break;

                case 8:
                    reportController.viewHighestConsumption(); // Show highest energy consumer
                    break;

                case 9:
                    carbonController.viewCarbonFootprintReport(); // Generate carbon footprint report
                    break;

                case 10:
                    energyAlertController.viewEnergyAlerts(); // Display energy alerts
                    break;

                case 11:
                    energyUsageController.recordEnergyUsage(); // Record energy usage
                    break;

                case 12:
                    energyUsageController.viewUsageRecords(); // View energy usage records
                    break;

                case 13:
                    running = false; // Exit application
                    mainMenuView.showMessage("Thank you for using Household Energy Consumption Tracker.");
                    break;

                default:
                    mainMenuView.showInvalidChoice(); // Invalid option
                    break;

            }

        }

    }

}