package controllers;

import repository.tables.Employee;
import utilities.input.InputReceiver;
import utilities.output.OutputProducer;
import repository_utils.Repository;

public class EmployeeController {
    private static final Repository<Employee> repository = new Repository<>(Employee.class);
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
        repository.save(employee);
    }
}
