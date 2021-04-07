package controllers;

import repository.methods.CoordinateRepository;
import repository.methods.EmployeeRepository;
import repository.tables.Employee;
import utilities.input.InputReceiver;
import utilities.messages.Message;
import utilities.output.OutputProducer;
import repository_utils.Repository;


public class EmployeeController {
    private final EmployeeRepository employeeRepository = new EmployeeRepository();
    private final Message messages = new Message();
    private final CoordinateRepository coordinateRepository = new CoordinateRepository();
    private final OutputProducer out = new OutputProducer();
    private final InputReceiver in = new InputReceiver();

    public void addEmployee() {
        Employee employee = new Employee();
        out.produce("---REGISTRACIJA---");
        out.produce("Darbuotojo vardas: ");
        employee.setFirstName(in.receiveLine().next());
        out.produce("Darbuotojo pavarde: ");
        employee.setLastName(in.receiveLine().next());
        out.produce("Darbuotojo amžius YYYY-MM-DD:");
        employee.setAge(in.receiveLine().next());
        addCity(employee);
        employeeRepository.save(employee);
    }

    public void addCity(Employee employee) {
        out.produce("Gyvenviete: ");
        String city = in.receiveLine().next();
        if(coordinateRepository.isLocationValid(city)) {
            employee.setCity(city);
        } else {
            out.produce("Validus miestai: ");
            messages.printCityList();
            addCity(employee);
        }
    }

    public void applyJob() {
        out.produce("--- IDARBINIMAS ---");
        employeeRepository.displayEmployees();
        out.produce("Darbuotojo ID: ");
        Employee employee = employeeRepository.find(in.receiveLine().nextInt());


    }
}
