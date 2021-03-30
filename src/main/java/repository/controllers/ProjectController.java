package repository.controllers;

import utilities.input.InputReceiver;
import utilities.output.OutputProducer;


public class ProjectController {
    OutputProducer out = new OutputProducer();
    InputReceiver input = new InputReceiver();
    private int choice;


    public void startApp() {  // First/Main screen
        while (true) {
            printMainMenu();
            choice = input.receiveLine().nextInt();
            switch (choice) {
                case 1:
                    employee();
                    break;
                case 2:
                    client();
                    break;
                case 0:
                    break;
            }
        }
    }

    public void printMainMenu() {
        out.produce("Sveiki atvykę į įdarbinimo agentūrą");
        out.produce("1. Darbuotojų meniu");
        out.produce("2. Užsakovų meniu");
        out.produce("0. Išeiti");
    }

    public void printEmployeeMenu() {
        out.produce("1. Registuoti darbuotoją.");
        out.produce("2. Priimti darbuotoją.");
        out.produce("0. Grįžti į pagrindinį.");
    }

    public void printClientMenu() {
        out.produce("1. Pridėti užsakymą.");
        out.produce("2. Atšaukti užsakymą.");
        out.produce("3. Redaguoti užsakymą.");
        out.produce("4. Grįžti į pagrindinį.");
    }


    private void employee() {
        while (true) {
            printEmployeeMenu();
            choice = input.receiveLine().nextInt();
            switch (choice) {
                case 1:
                    EmployeeController.addEmployee();
                    break;
            }
        }
    }

    private void client() {
        while (true) {
            printClientMenu();
            choice = input.receiveLine().nextInt();
        }
    }
}