package ApplianceModule.Utilities;

// Utility class for validating appliance input values
public class ApplianceValidator {

    // Validates that the power value is positive
    public static boolean validatePower(double power) {
        return power > 0;
    }

    // Validates that the hours used is zero or positive
    public static boolean validateHours(double hours) {
        return hours >= 0;
    }
}