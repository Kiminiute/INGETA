package controllers;

import repository.methods.*;
import repository.tables.Employee;
import repository.tables.Job;
import repository.tables.WorkingEmployee;
import utilities.input.InputReceiver;
import utilities.messages.Message;
import utilities.output.OutputProducer;


public class EmployeeController {
    private final EmployeeRepository employeeRepository = new EmployeeRepository();
    private final LocationRepository locationRepository = new LocationRepository();
    private final JobRepository jobRepository = new JobRepository();
    private final Message messages = new Message();
    private final CoordinateRepository coordinateRepository = new CoordinateRepository();
    private final OutputProducer out = new OutputProducer();
    private final InputReceiver in = new InputReceiver();
    private final WorkingEmployeeRepository wkr = new WorkingEmployeeRepository();
    private String choice = "";

    public void addEmployee() {
        Employee employee = new Employee();
        out.produce("---REGISTRACIJA---");
        out.produce("Darbuotojo vardas: ");
        employee.setFirstName(in.receiveLine().next());
        out.produce("Darbuotojo pavarde: ");
        employee.setLastName(in.receiveLine().next());
        out.produce("Darbuotojo amžius:");
        employee.setAge(in.receiveLine().next());
        addCity(employee);
        out.produce("Kokiu km spinduliu ieskomas darbas: ");
        employee.setDistanceToWork(in.receiveLine().nextDouble());
        employeeRepository.save(employee);
    }

    public void addCity(Employee employee) {
        out.produce("Gyvenvietė: ");
        String city = in.receiveLine().next();
        if (locationRepository.isLocationValid(city)) {
            employee.setCity(city);
        } else {
            out.produce("Validūs miestai: ");
            messages.printCityList();
            addCity(employee);
        }
    }

    public void applyJob() {
        WorkingEmployee we = new WorkingEmployee();
        out.produce("--- ĮDARBINIMAS ---");
        employeeRepository.displayEmployees();
        out.produce("Darbuotojo ID: ");
        Employee employee = employeeRepository.find(in.receiveLine().nextInt());
        out.produce("Rekomenduojami darbai pagal atstumą: ");
        messages.printFilteredJobs(employee);
        out.produce("Rodyti visus darbus nepaisant atstumo? T/N");
        choice = in.receiveLine().next();
        if(choice.equalsIgnoreCase("T")) {
            messages.printJobList();
        }
        out.produce("Darbo ID: ");
        Job job = jobRepository.find(in.receiveLine().nextInt());
        we.setJob(job);
        we.setClient(job.getClient());
        employee.setAvailable(false);
        wkr.save(we);
        out.produce("Sekmingai įdarbinta!");
    }
}
