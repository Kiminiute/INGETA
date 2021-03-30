package controllers;

import org.hibernate.Transaction;
import repository.tables.Employee;
import utilities.input.InputReceiver;
import utilities.output.OutputProducer;
import utilities.session.SessionProducer;

public class EmployeeController {
    private static final SessionProducer session = new SessionProducer();
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
        out.produce("Darbuotojo pageidaujamas valandinis atlygis: ");
        employee.setDesiredSalary(in.receiveLine().nextDouble());
        Transaction transaction = session.produceSession().beginTransaction();
        session.produceSession().save(employee);
        transaction.commit();
        session.produceSession().close();
    }
}
