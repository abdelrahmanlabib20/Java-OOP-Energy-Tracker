package BillCalculatorModule.View;

import BillCalculatorModule.Entity.Bill;
import java.util.Scanner;

public class BillView {

    private Scanner scanner = new Scanner(System.in);

    // Get user input to create a Bill object
    public Bill getBillDetails() {

        System.out.print("Enter Power (Watts): ");
        double power = scanner.nextDouble();

        System.out.print("Enter Hours Used Per Day: ");
        double hours = scanner.nextDouble();

        System.out.print("Enter Number of Days: ");
        int days = scanner.nextInt();

        System.out.print("Enter Price Per kWh: ");
        double price = scanner.nextDouble();

        // Return a new Bill object with the collected details
        return new Bill(power
                , hours, days, price);
    }

    // Display the calculated results of the Bill
    public void displayBillResult(Bill bill) {

        System.out.println("\n===== BILL REPORT =====");

        System.out.printf(
                "Daily Energy: %.2f kWh%n",
                bill.getDailyEnergy() // Display daily energy usage
        );

        System.out.printf(
                "Monthly Energy: %.2f kWh%n",
                bill.getMonthlyEnergy() // Display monthly energy usage
        );

        System.out.printf(
                "Total Cost: RM %.2f%n",
                bill.getTotalBill() // Display total calculated bill
        );
    }

    // General-purpose message display
    public void showMessage(String message) {
        System.out.println(message);
    }
}