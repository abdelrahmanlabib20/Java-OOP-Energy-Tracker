package ApplianceModule.Service;

import ApplianceModule.entity.Appliance;
import java.util.ArrayList;

// Service class to manage appliances
public class ApplianceService {

    // Stores all appliances
    private ArrayList<Appliance> appliances = new ArrayList<>();

    // Adds a new appliance to the list
    public void addAppliance(Appliance appliance) {
        appliances.add(appliance);
    }

    // Returns the list of all appliances
    public ArrayList<Appliance> getAllAppliances() {
        return appliances;
    }

    // Edits hours used for a specific appliance by name
    public boolean editAppliance(String name, double newHours) {
        for (Appliance appliance : appliances) {
            if (appliance.getName().equalsIgnoreCase(name)) {
                appliance.setHoursUsed(newHours);
                return true;
            }
        }
        return false; // Return false if appliance not found
    }

    // Deletes an appliance by name
    public boolean deleteAppliance(String name) {
        for (int i = 0; i < appliances.size(); i++) {
            if (appliances.get(i).getName().equalsIgnoreCase(name)) {
                appliances.remove(i);
                return true;
            }
        }
        return false;
    }

    // Calculates total energy consumption of all appliances
    public double calculateTotalConsumption() {
        double total = 0;
        for (Appliance appliance : appliances) {
            total += appliance.calculateEnergyConsumption();
        }
        return total;
    }

    // Calculates average energy consumption
    public double calculateAverageConsumption() {
        if (appliances.isEmpty()) {
            return 0;
        }
        return calculateTotalConsumption() / appliances.size();
    }

    // Finds the appliance with highest energy consumption
    public Appliance findHighConsumptionAppliance() {
        if (appliances.isEmpty()) {
            return null;
        }
        Appliance highest = appliances.get(0);
        for (Appliance appliance : appliances) {
            if (appliance.calculateEnergyConsumption() > highest.calculateEnergyConsumption()) {
                highest = appliance;
            }
        }
        return highest;
    }

    // Wrapper method for highest consumption appliance
    public Appliance getHighestConsumptionAppliance() {
        return findHighConsumptionAppliance();
    }
}