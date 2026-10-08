package ReportModule.Controller;

import ReportModule.Entity.EnergyReport;
import ReportModule.Service.ReportModule;
import ReportModule.view.ReportView;

public class ReportController {

    private ReportView reportView;      
    private ReportModule reportModule;

    // Constructor to initialize view and service
    public ReportController(ReportView reportView, ReportModule reportModule){
        this.reportView = reportView;
        this.reportModule = reportModule;
    }

    // Generate and display summary report
    public void generateSummaryReport(){

        // Get price per kWh from user input
        double pricePerKWh = reportView.getPricePerKWh();

        // Generate report using the service
        EnergyReport report = reportModule.generateReport(pricePerKWh);

        // Display total, average, and estimated cost
        reportView.displaySummaryReport(
                report.getTotalConsumption(),
                report.getAverageConsumption(),
                report.getEstimatedCost()
        );
    }

    // Display the appliance with highest energy consumption
    public void viewHighestConsumption(){

        // Generate report (price not needed, set 0)
        EnergyReport report = reportModule.generateReport(0);

        // Display highest consuming appliance
        reportView.displayHighConsumptionAppliance(
                report.getHighestConsumer()
        );
    }
}