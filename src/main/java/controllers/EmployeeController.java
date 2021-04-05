package controllers;

import repository.methods.CoordinateRepository;
import repository.tables.Employee;
import utilities.input.InputReceiver;
import utilities.messages.Message;
import utilities.output.OutputProducer;
import repository_utils.Repository;


public class EmployeeController {
    private static final Repository<Employee> repository = new Repository<>(Employee.class);
    private static final Message messages = new Message();
    private static final CoordinateRepository cr = new CoordinateRepository();
    private static final OutputProducer out = new OutputProducer();
    private static final InputReceiver in = new InputReceiver();

    public static void addEmployee() {
        Employee employee = new Employee();
        out.produce("---REGISTRACIJA---");
        out.produce("Darbuotojo vardas: ");
        employee.setFirstName(in.receiveLine().next());
        out.produce("Darbuotojo pavarde: ");
        employee.setLastName(in.receiveLine().next());
        out.produce("Darbuotojo amžius YYYY-MM-DD:");
        employee.setAge(in.receiveLine().next());
        addCity(employee);
        repository.save(employee);
    }

    public static void addCity(Employee employee) {
        out.produce("City you live in: ");
        String city = in.receiveLine().next();
        if(cr.isLocationValid(city)) {
            employee.setCity(city);
        } else {
            out.produce("Valid cities: ");
            messages.printCityList();
            addCity(employee);
        }
    }
}
