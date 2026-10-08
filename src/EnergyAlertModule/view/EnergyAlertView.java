package EnergyAlertModule.view;

// View class for displaying energy alerts to the user
public class EnergyAlertView {

    // Display daily energy usage alert
    public void displayDailyAlert(double dailyUsage, double dailyLimit, String status) {
        System.out.println("\n===== Daily Energy Alert =====");
        System.out.printf("Daily Usage : %.2f kWh%n", dailyUsage);
        System.out.printf("Daily Limit : %.2f kWh%n", dailyLimit);
        System.out.println(status);
    }

    // Display monthly energy usage alert
    public void displayMonthlyAlert(double monthlyUsage, double monthlyLimit, String status) {
        System.out.println("\n===== Monthly Energy Alert =====");
        System.out.printf("Monthly Usage : %.2f kWh%n", monthlyUsage);
        System.out.printf("Monthly Limit : %.2f kWh%n", monthlyLimit);
        System.out.println(status);
    }

    // Display individual appliance energy usage alert with suggestions
    public void displayApplianceAlert(String applianceName, double applianceUsage, double applianceLimit, String status, String suggestion) {
        System.out.println("\n===== Appliance Energy Alert =====");
        System.out.println("Appliance Name : " + applianceName);
        System.out.printf("Usage          : %.2f kWh%n", applianceUsage);
        System.out.printf("Limit          : %.2f kWh%n", applianceLimit);
        System.out.println(status);
        System.out.println("Suggestion     : " + suggestion);
    }

    // General method to display messages
    public void showMessage(String message) {
        System.out.println(message);
    }
}

