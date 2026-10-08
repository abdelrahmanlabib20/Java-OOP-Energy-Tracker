package EnergyAlertModule.Utilities;

// Utility class for checking energy usage limits and providing suggestions
public class AlertChecker {

    // Check if usage exceeds limit or is negative
    public static String checkLimit(double usage, double limit, String type) {
        if (usage < 0) {
            return "Error: " + type + " usage cannot be negative.";
        } else if (usage > limit) {
            return "Alert: " + type + " energy limit exceeded!";
        } else {
            return "Status: " + type + " usage is within the limit.";
        }
    }

    // Suggest actions based on appliance type
    public static String getSuggestion(String applianceName) {
        String name = applianceName.toLowerCase();
        if (name.contains("air") || name.contains("conditioner") || name.contains("ac")) {
            return "Set the air conditioner to 24°C or higher.";
        } else if (name.contains("light") || name.contains("lamp")) {
            return "Use LED bulbs and switch off lights when not needed.";
        } else if (name.contains("fan")) {
            return "Turn off the fan when leaving the room.";
        } else if (name.contains("fridge") || name.contains("refrigerator")) {
            return "Do not open the fridge door too often.";
        } else {
            return "Reduce usage time and unplug the appliance when not in use.";
        }
    }

    // Generate general alert message based on severity
    public static String generateMessage(String severity) {
        if (severity.equals("HIGH")) {
            return "Energy consumption is very high.";
        } else if (severity.equals("MEDIUM")) {
            return "Consider reducing energy usage.";
        } else {
            return "Energy usage is acceptable.";
        }
    }
}