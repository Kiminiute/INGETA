import controllers.ClientController;
import controllers.EmployeeController;
import hibernate_utils.HibernateUtils;
import repository.methods.LocationRepository;
import utilities.input.InputReceiver;
import utilities.messages.Message;
import utilities.output.OutputProducer;


public class Project {
    private LocationRepository locationRepository;
    private final Message message = new Message();
    private final EmployeeController ec = new EmployeeController();
    private final OutputProducer out = new OutputProducer();
    private final InputReceiver input = new InputReceiver();
    private final ClientController cc = new ClientController();
    private int choice;

    public Project() {
        locationRepository = new LocationRepository();
        locationRepository.initializeLocationsToRepo();
        startApp();
    }

    public void startApp() {  // First/Main screen
        message.printMainMenu();
        choice = input.receiveLine().nextInt();
        switch (choice) {
            case 1:
                employeeMenu();
                break;
            case 2:
                clientMenu();
                break;
            case 3:
                startApp();
                break;
            case 0:
                HibernateUtils.shutdown();
                return;
            default:
                out.produceErr("Komanda neatpažinta");
                startApp();
        }
    }

    private void employeeMenu() {
        message.printEmployeeMenu();
        choice = input.receiveLine().nextInt();
        switch (choice) {
            case 1:
                ec.addEmployee();
                employeeMenu();
                break;
            case 2:
                ec.applyJob();
                employeeMenu();
                break;
            case 0:
                startApp();
                break;
            default:
                out.produceErr("Komanda neatpažinta");
                employeeMenu();
        }
    }

    private void clientMenu() {
        message.printClientMenu();
        choice = input.receiveLine().nextInt();
        switch (choice) {
            case 1:
                cc.addClient();
                clientMenu();
            case 2:
                cc.addJob();
                clientMenu();
                break;
            case 0:
                startApp();
                break;
            default:
                out.produceErr("Komanda neatpažinta");
                clientMenu();
        }
    }
}