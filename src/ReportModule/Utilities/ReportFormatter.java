package ReportModule.Utilities;

// Utility class to format report output for display
public class ReportFormatter {

    // Format a title with separators
    public static String formatTitle(String title){
        return "===== " + title + " =====";
    }

    // Format energy values with 2 decimal places and kWh unit
    public static String formatEnergy(double energy){
        return String.format("%.2f kWh", energy);
    }

    // Format cost values with 2 decimal places and RM currency
    public static String formatCost(double cost){
        return String.format("%.2f RM", cost);
    }

}