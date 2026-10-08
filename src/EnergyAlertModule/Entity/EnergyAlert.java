package EnergyAlertModule.Entity;

// Represents an energy alert for daily, monthly, or appliance usage
public class EnergyAlert {

    private String alertType;   // Type of alert (Daily, Monthly, Appliance)
    private String message;     // Alert message
    private String severity;    // Severity level (LOW, MEDIUM, HIGH)
    private double energyUsage; // Energy usage related to the alert (kWh)

    // Constructor initializes all fields
    public EnergyAlert(String alertType,
                       String message,
                       String severity,
                       double energyUsage) {
        this.alertType = alertType;
        this.message = message;
        this.severity = severity;
        this.energyUsage = energyUsage;
    }

    // Getters and setters
    public String getAlertType() { return alertType; }
    public void setAlertType(String alertType) { this.alertType = alertType; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public String getSeverity() { return severity; }
    public void setSeverity(String severity) { this.severity = severity; }

    public double getEnergyUsage() { return energyUsage; }
    public void setEnergyUsage(double energyUsage) { this.energyUsage = energyUsage; }

    // Returns a formatted string of the alert information
    @Override
    public String toString() {
        return "Alert Type: " + alertType +
                "\nMessage: " + message +
                "\nSeverity: " + severity +
                "\nEnergy Usage: " + energyUsage + " kWh";
    }
}