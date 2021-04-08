import controllers.ClientController;
import controllers.EmployeeController;
import repository.tables.Client;
import utilities.dateOperations.DateValidator;
import utilities.generator.EmployeeGenerator;
import utilities.input.InputReceiver;

import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
      //  new Project();

        EmployeeGenerator employeeGenerator = new EmployeeGenerator();
        employeeGenerator.generateEmployees(100);
        ClientController clientController = new ClientController();

        Client client= new Client("Kompanija", "Kaunas",
                LocalDate.of(2010, 10,10),
                LocalDate.of(2010,12,12),
                "Pagalbinis", 12.5,
                EmployeeController.findEmployee(5));

        Client client1= new Client("Kompanijaaa", "Vilnius",
                LocalDate.of(2020, 10,10),
                LocalDate.of(2020,12,12),
                "Suvirintojas", 12.5,
                EmployeeController.findEmployee(4));

        clientController.addClient(client);
        clientController.addClient(client1);
Project project = new Project();

//        InputReceiver inputReceiver = new InputReceiver();
//       LocalDate date = inputReceiver.receiveDate();
//        System.out.println(date);


//        System.out.println("--------------------------------------------------------------------------------------");
//        AvailableEmployees availableEmployees = new AvailableEmployees();
//        List<Employee>employeeList = availableEmployees.getAvailableEmployees(client);
//        List<Employee>employeeList1 = availableEmployees.getAvailableEmployees(client1);
//        for(Employee e : employeeList){
//            System.out.println("***************" + e.toString() + "***************");
//        }
//        System.out.println("--------------------------------------------------------------------------------------");
//        for(Employee e : employeeList1){
//            System.out.println("***************" + e.toString() + "***************");
//        }


    }
}