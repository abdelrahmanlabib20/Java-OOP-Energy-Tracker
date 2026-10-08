package CarbonFootprintModule.View;

import CarbonFootprintModule.Entity.CarbonReport;

public class CarbonView {

    // Display the carbon footprint report
    public void displayReport(CarbonReport report) {
        System.out.println("\n===== Carbon Footprint Report =====");
        System.out.println(report);
    }

    // Display any general message to the user
    public void showMessage(String message){
        System.out.println(message);
    }
}