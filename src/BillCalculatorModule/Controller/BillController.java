package BillCalculatorModule.Controller;

import BillCalculatorModule.Entity.Bill;
import BillCalculatorModule.Service.BillCalculatorModule;
import BillCalculatorModule.View.BillView;
import BillCalculatorModule.Utilities.BillValidator;

public class BillController {

    private BillView view;
    private BillCalculatorModule service;

    // Constructor to initialize view and service
    public BillController(BillView view, BillCalculatorModule service) {
        this.view = view;
        this.service = service;
    }

    // Handles user input and calculates the bill
    public void calculateBill() {

        // 1. Get user input for the bill

        
        Bill bill = view.getBillDetails();

        // 2. Validate user input using BillValidator
        if (BillValidator.validatePower(bill.getPowerWatts())
                && BillValidator.validateHours(bill.getHoursPerDay())
                && BillValidator.validateDays(bill.getDays())
                && BillValidator.validatePrice(bill.getPricePerKWh())) {

            // 3. Call service to calculate the bill
            service.calculateBill(bill);

            // 4. Display the calculated bill
            view.displayBillResult(bill);

        } else {
            // Show error if any input is invalid
            view.showMessage("Invalid bill information.");
        }
    }
}