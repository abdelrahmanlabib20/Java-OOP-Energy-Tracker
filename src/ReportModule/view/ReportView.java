package ReportModule.view;

import ApplianceModule.entity.Appliance;
import ReportModule.Utilities.ReportFormatter;

import java.util.Scanner;

// View class to display reports and gather input for report calculations
public class ReportView {

    private Scanner input = new Scanner(System.in);

    // Prompt user to enter the price per kWh
    public double getPricePerKWh(){
        System.out.print("Enter price per kWh: ");
        return input.nextDouble();
    }

    // Display total energy consumption
    public void displayTotalConsumption(double totalKWh){
        System.out.println(ReportFormatter.formatTitle("Total Energy Consumption"));
        System.out.println("Total Energy Used = " + ReportFormatter.formatEnergy(totalKWh));
    }

    // Display a detailed summary report
    public void displaySummaryReport(double totalKWh, double averageKWh, double estimatedCost){
        System.out.println(ReportFormatter.formatTitle("Summary Report"));
        System.out.println("Total Energy Used = " + ReportFormatter.formatEnergy(totalKWh));
        System.out.println("Average Energy Usage = " + ReportFormatter.formatEnergy(averageKWh));
        System.out.println("Estimated Cost = " + ReportFormatter.formatCost(estimatedCost));
    }

    // Display the appliance with the highest energy consumption
    public void displayHighConsumptionAppliance(Appliance appliance){
        System.out.println(ReportFormatter.formatTitle("High Consumption Appliance"));

        if(appliance == null){
            System.out.println("No appliance data available.");
        } else {
            System.out.println(appliance);
        }
    }
}