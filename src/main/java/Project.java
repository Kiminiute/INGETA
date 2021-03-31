import controllers.EmployeeController;
import utilities.input.InputReceiver;
import utilities.messages.Message;
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
            Message.printMainMenu();
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

    private void employeeMenu() {
        while (true) {
            Message.printEmployeeMenu();
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
            Message.printClientMenu();
            choice = input.receiveLine().nextInt();
        }
    }
}