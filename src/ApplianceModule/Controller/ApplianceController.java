
 package ApplianceModule.Controller;


import ApplianceModule.Service.ApplianceService;
import ApplianceModule.View.ApplianceView;
import ApplianceModule.entity.Appliance;
import ApplianceModule.entity.LightAppliance;
import ApplianceModule.entity.CoolingAppliance;

import ApplianceModule.Utilities.ApplianceValidator;
public class ApplianceController {


    private ApplianceView applianceView;

    private ApplianceService applianceService;



    public ApplianceController(
            ApplianceView applianceView,
            ApplianceService applianceService) {


        this.applianceView = applianceView;
        this.applianceService = applianceService;

    }

    // Handles adding a new appliance by collecting user input, validating data, and creating the correct appliance type.
    public void addAppliance() {



        int type =
                applianceView.getApplianceType();

        Appliance applianceDetails =
                applianceView.getApplianceDetails();
        double power =
                applianceDetails.getPower();

        double hours =
                applianceDetails.getHoursUsed();


         // Prevent invalid energy values from being stored in the system.

        if(!ApplianceValidator.validatePower(power)
                ||
           !ApplianceValidator.validateHours(hours)){


            applianceView.showMessage(
                    "Invalid power or hours value."
            );


            return;

        }

        Appliance appliance;
        // Demonstrates polymorphism by creating different appliance subclasses using a parent reference.
        if(type == 1){
            String lightType =
                    applianceView.getLightType();
            appliance =
                    new LightAppliance(
                            applianceDetails.getName(),
                            power,
                            hours,
                            lightType
                    );
        }
        // Type 2 = Cooling

        else if(type == 2){
            String coolingType =
                    applianceView.getCoolingType();

            appliance =
                    new CoolingAppliance(
                            applianceDetails.getName(),
                            power,
                            hours,
                            coolingType
                    );
        }
        else{
            applianceView.showMessage(
                    "Invalid appliance type."
            );
            return;
        }
        // Sends the created appliance object to the service layer for storage.

        applianceService.addAppliance(appliance);
        applianceView.showMessage(
                "Appliance added successfully."
        );
    }

    // Updates the usage hours of an existing appliance.
    public void editAppliance() {
        String name =
                applianceView.getApplianceName();
        double hours =
                applianceView.getNewHoursUsed();
        if(!ApplianceValidator.validateHours(hours)){
            applianceView.showMessage(
                    "Invalid hours value."
            );
            return;

        }
        boolean result =
                applianceService.editAppliance(
                        name,
                        hours
                );
        if(result){
            applianceView.showMessage(
                    "Appliance updated successfully."
            );
        }
        else{
            applianceView.showMessage(
                    "Appliance not found."
            );
        }


    }

    public void deleteAppliance() {



        String name =
                applianceView.getApplianceName();




        boolean result =
                applianceService.deleteAppliance(name);




        if(result){


            applianceView.showMessage(
                    "Appliance deleted successfully."
            );


        }
        else{


            applianceView.showMessage(
                    "Appliance not found."
            );


        }


    }
    // Displays all stored appliances by requesting dat
    public void viewAllAppliances() {


        applianceView.displayAppliances(
                applianceService.getAllAppliances()
        );


    }

    // Calculates and displays the total household energy consumption.

    public void viewTotalConsumption() {



        double total =
                applianceService.calculateTotalConsumption();



        applianceView.displayTotalConsumption(total);


    }



}