package CarbonFootprintModule.Controller;

import ApplianceModule.Service.ApplianceService;
import CarbonFootprintModule.Entity.CarbonReport;
import CarbonFootprintModule.Service.CarbonFootprintModule;
import CarbonFootprintModule.View.CarbonView;

public class CarbonController {

    private CarbonView view;
    private ApplianceService applianceService;
    private CarbonFootprintModule service;

    // Constructor initializes view, appliance service, and carbon service
    public CarbonController(
            CarbonView view,
            ApplianceService applianceService,
            CarbonFootprintModule service) {

        this.view = view;
        this.applianceService = applianceService;
        this.service = service;
    }

    // Generate and display the carbon footprint report
    public void viewCarbonFootprintReport(){

        // Calculate carbon report using appliance data
        CarbonReport report = service.analyzeCarbon(applianceService);

        // Send the report to the view for display
        view.displayReport(report);
    }
}