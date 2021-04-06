import controllers.AvailableEmployees;
import controllers.ClientController;
import controllers.EmployeeController;
import controllers.WorkingEmployeesController;
import repository.tables.Client;
import repository.tables.Employee;
import utilities.generator.EmployeeGenerator;

import java.time.LocalDate;
import java.util.List;

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

        System.out.println("--------------------------------------------------------------------------------------");
        AvailableEmployees availableEmployees = new AvailableEmployees();
        List<Employee>employeeList = availableEmployees.getAvailableEmployees(client);
        List<Employee>employeeList1 = availableEmployees.getAvailableEmployees(client1);
        for(Employee e : employeeList){
            System.out.println("***************" + e.toString() + "***************");
        }
        System.out.println("--------------------------------------------------------------------------------------");
        for(Employee e : employeeList1){
            System.out.println("***************" + e.toString() + "***************");
        }


    }
}