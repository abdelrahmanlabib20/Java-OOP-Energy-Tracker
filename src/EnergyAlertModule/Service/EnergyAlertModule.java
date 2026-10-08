package EnergyAlertModule.Service;

import EnergyAlertModule.Utilities.AlertChecker;

// Service module for energy alert logic
public class EnergyAlertModule {

    private double dailyLimitKWh;      // Maximum allowed daily energy usage
    private double monthlyLimitKWh;    // Maximum allowed monthly energy usage
    private double applianceLimitKWh;  // Maximum allowed usage for a single appliance

    // Default constructor sets standard limits
    public EnergyAlertModule() {
        this.dailyLimitKWh = 10.0;
        this.monthlyLimitKWh = 300.0;
        this.applianceLimitKWh = 15.0;
    }

    // Constructor with custom limits
    public EnergyAlertModule(double dailyLimitKWh, double monthlyLimitKWh, double applianceLimitKWh) {
        setDailyLimitKWh(dailyLimitKWh);
        setMonthlyLimitKWh(monthlyLimitKWh);
        setApplianceLimitKWh(applianceLimitKWh);
    }

    // Getters and setters with validation
    public double getDailyLimitKWh() { return dailyLimitKWh; }
    public void setDailyLimitKWh(double dailyLimitKWh) {
        this.dailyLimitKWh = (dailyLimitKWh <= 0) ? 10.0 : dailyLimitKWh;
    }

    public double getMonthlyLimitKWh() { return monthlyLimitKWh; }
    public void setMonthlyLimitKWh(double monthlyLimitKWh) {
        this.monthlyLimitKWh = (monthlyLimitKWh <= 0) ? 300.0 : monthlyLimitKWh;
    }

    public double getApplianceLimitKWh() { return applianceLimitKWh; }
    public void setApplianceLimitKWh(double applianceLimitKWh) {
        this.applianceLimitKWh = (applianceLimitKWh <= 0) ? 15.0 : applianceLimitKWh;
    }

    // Methods to get status for daily, monthly, and appliance usage
    public String getDailyStatus(double dailyUsageKWh) {
        return AlertChecker.checkLimit(dailyUsageKWh, dailyLimitKWh, "Daily");
    }

    public String getMonthlyStatus(double monthlyUsageKWh) {
        return AlertChecker.checkLimit(monthlyUsageKWh, monthlyLimitKWh, "Monthly");
    }

    public String getApplianceStatus(double applianceUsageKWh) {
        return AlertChecker.checkLimit(applianceUsageKWh, applianceLimitKWh, "Appliance");
    }

    // Suggestion for a specific appliance
    public String giveSuggestion(String applianceName) {
        return AlertChecker.getSuggestion(applianceName);
    }

    // Generate general alert message based on severity
    public String getAlertMessage(String severity) {
        return AlertChecker.generateMessage(severity);
    }
}