package Menu.view;

import java.util.Scanner;

public class MainMenuView {

    private Scanner input = new Scanner(System.in);

    // Display main menu and get user's selection
    public int showMenuAndGetChoice() {
        System.out.println(":------------Household Energy Tracker-------------:");
        System.out.println("1. Add Appliance");
        System.out.println("2. Edit Appliance Usage");
        System.out.println("3. Delete Appliance");
        System.out.println("4. View All Appliances");
        System.out.println("5. View Total Consumption");
        System.out.println("6. View Estimated Bill");
        System.out.println("7. View Summary Report");
        System.out.println("8. Identify High Consumption Appliance");
        System.out.println("9. View Carbon Footprint Report");
        System.out.println("10. View Energy Alerts");
        System.out.println("11. Record Energy Usage");
        System.out.println("12. View Energy Usage Records");
        System.out.println("13. Exit");
        System.out.print("Choose an option: ");

        int choice = input.nextInt();
        input.nextLine(); // Clear newline

        return choice;
    }

    // Display a custom message to the user
    public void showMessage(String message) {
        System.out.println(message);
    }

    // Display message for invalid menu choice
    public void showInvalidChoice() {
        System.out.println("Invalid choice! Try again.");
    }
}