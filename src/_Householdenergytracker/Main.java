package _Householdenergytracker;

import Menu.Controller.MainController;

public class Main {

    // Entry point for the Household Energy Tracker application
    public static void main(String[] args) {

        // Create MainController instance to manage all modules
        MainController mainController = new MainController();

        // Start the main menu 
        mainController.start();
    }
}