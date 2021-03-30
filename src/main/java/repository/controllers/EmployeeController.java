package repository.controllers;

import org.hibernate.Transaction;
import repository.tables.Employee;
import utilities.input.InputReceiver;
import utilities.output.OutputProducer;
import utilities.session.SessionProducer;

public class EmployeeController {
    private final SessionProducer session = new SessionProducer();
    private final OutputProducer out = new OutputProducer();
    private final InputReceiver in = new InputReceiver();

    public  void addEmployee() {
        Employee employee = new Employee();
        out.produce("---REGISTRACIJA---");
        out.produce("Darbuotojo vardas: ");
        employee.setFirstName(in.receiveLine().next());
        out.produce("Darbuotojo pavarde: ");
        employee.setLastName(in.receiveLine().next());
        out.produce("Darbuotojo amžius YYYY-MM-DD:");
        employee.setAge(in.receiveLine().next());
        out.produce("Darbuotojo pageidaujamas valandinis atlygis: ");
        employee.setDesiredSalary(in.receiveLine().nextDouble());
        Transaction transaction = session.produceSession().beginTransaction();
        session.produceSession().save(employee);
        transaction.commit();
        session.produceSession().close();
    }
}
