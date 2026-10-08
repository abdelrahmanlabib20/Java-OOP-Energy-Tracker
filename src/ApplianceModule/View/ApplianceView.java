package ApplianceModule.View;

import ApplianceModule.entity.Appliance;
import java.util.ArrayList;
import java.util.Scanner;

public class ApplianceView {

    private Scanner scanner = new Scanner(System.in);

    // Ask the user to select the type of appliance
    public int getApplianceType() {
        System.out.println("\nChoose Appliance Type:");
        System.out.println("1. Light Appliance");
        System.out.println("2. Cooling Appliance");

        System.out.print("Enter choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // clear the newline left in buffer
        return choice;
    }

    // Get basic appliance details from the user
    public Appliance getApplianceDetails() {
        System.out.print("Enter Appliance Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Power (Watts): ");
        double power = scanner.nextDouble();

        System.out.print("Enter Hours Used: ");
        double hoursUsed = scanner.nextDouble();

        scanner.nextLine(); // clear Enter key

        return new Appliance(name, power, hoursUsed);
    }

    // Ask for the name of an appliance
    public String getApplianceName() {
        System.out.print("Enter Appliance Name: ");
        return scanner.nextLine();
    }

    // Ask for new usage hours for editing
    public double getNewHoursUsed() {
        System.out.print("Enter New Hours Used: ");
        return scanner.nextDouble();
    }

    // Display all appliances in a list
    public void displayAppliances(ArrayList<Appliance> appliances) {
        System.out.println("\n===== Appliance List =====");

        if (appliances.isEmpty()) {
            System.out.println("No appliances found.");
            return;
        }

        for (Appliance appliance : appliances) {
            System.out.println("-----------------------");
            System.out.println(appliance);
        }
        System.out.println("-----------------------");
    }

    // Display total energy consumption of all appliances
    public void displayTotalConsumption(double total) {
        System.out.println("\n===== Total Energy Consumption =====");
        System.out.printf("Total Consumption: %.2f kWh%n", total);
    }

    // Get the type of light appliance from the user
    public String getLightType() {
        System.out.print("Enter Light Type e.g. LED/Bulb/Tube Light: ");
        return scanner.nextLine();
    }

    // Get the type of cooling appliance from the user
    public String getCoolingType() {
        System.out.print("Enter Cooling Type e.g. Air Conditioner/Fan/Water Cooling: ");
        return scanner.nextLine();
    }

    // Display a general message to the user
    public void showMessage(String message) {
        System.out.println(message);
    }
}