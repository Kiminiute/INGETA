import controllers.EmployeeController;
import utilities.input.InputReceiver;
import utilities.output.OutputProducer;



public class Project {
    OutputProducer out = new OutputProducer();
    InputReceiver input = new InputReceiver();
    private int choice;

    public Project() {
        startApp();
    }

    public void startApp() {  // First/Main screen
        while (true) {
            printMainMenu();
            choice = input.receiveLine().nextInt();
            switch (choice) {
                case 1:
                    employeeMenu();
                    break;
                case 2:
                    clientMenu();
                    break;
                case 0:
                    return;
                default:
                    out.produceErr("Komanda neatpažinta");
            }
        }
    }

    public void printMainMenu() {
        out.produce("=========== PAGRINDINIS ===========");
        out.produce("Sveiki atvykę į įdarbinimo agentūrą");
        out.produce("1. Darbuotojų meniu");
        out.produce("2. Užsakovų meniu");
        out.produce("0. Baigti programą");
        out.produce("===================================");
    }

    public void printEmployeeMenu() {
        out.produce("==== Darbuotojų meniu ====");
        out.produce("1. Registuoti darbuotoją.");
        out.produce("2. Priimti darbuotoją.");
        out.produce("0. Grįžti į pagrindinį.");
        out.produce("==========================");
    }

    public void printClientMenu() {
        out.produce("1. Pridėti užsakymą.");
        out.produce("2. Atšaukti užsakymą.");
        out.produce("3. Redaguoti užsakymą.");
        out.produce("4. Grįžti į pagrindinį.");
    }


    private void employeeMenu() {
        while (true) {
            printEmployeeMenu();
            choice = input.receiveLine().nextInt();
            switch (choice) {
                case 1:
                    EmployeeController.addEmployee();
                    break;
                case 0:
                    startApp();
                    break;
                default:
                    out.produceErr("Komanda neatpažinta");
            }
        }
    }

    private void clientMenu() {
        while (true) {
            printClientMenu();
            choice = input.receiveLine().nextInt();
        }
    }
}