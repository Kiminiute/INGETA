package utilities.messages;

import repository.methods.*;
import repository.tables.Coordinate;
import repository.tables.Employee;
import repository.tables.Job;
import repository.tables.Location;
import utilities.output.OutputProducer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Message {
    private final LocationRepository locationRepository = new LocationRepository();
    private final CoordinateRepository coordinateRepository = new CoordinateRepository();
    private final EmployeeRepository employeeRepository = new EmployeeRepository();
    private final ClientRepository clientRepository = new ClientRepository();
    private final WorkingEmployeeRepository workingEmployeeRepository = new WorkingEmployeeRepository();
    private final JobRepository jobRepository = new JobRepository();
    private final OutputProducer out = new OutputProducer();

    public void printMainMenu() {
        out.produce("=========== PAGRINDINIS ===========");
        out.produce("Sveiki atvykę į įdarbinimo agentūrą");
        out.produce("1. Darbuotojų meniu");
        out.produce("2. Užsakovų meniu");
        out.produce("0. Baigti programą");
        out.produce("===================================");
    }

    public void printEmployeeMenu() {
        out.produce("==== Darbuotojų meniu ====");
        out.produce("1. Registruoti darbuotoją.");
        out.produce("2. Priimti darbuotoją.");
        out.produce("3. Rodyti neužimtus darbuotojus.");
        out.produce("0. Grįžti į pagrindinį.");
        out.produce("==========================");
    }

    public void printClientMenu() {
        out.produce("1. Registruoti klientą");
        out.produce("2. Pridėti užsakymą.");
        out.produce("3. Atšaukti užsakymą.");
        out.produce("4. Klientų sąrašas");
        out.produce("5. Darbų sąrašas");
        out.produce("0. Grįžti į pagrindinį.");
    }

    public void printCityList() {
        for (Location city : locationRepository.findAll()) {
            out.produce(city.getName());
        }
    }

    public void printFilteredCities(Employee employee) {
        locationRepository.filterCities(employee).forEach
                (l -> System.out.println(coordinateRepository.find(l.getCoordinateId()).getLocation().getName()));
    }

    public void printFilteredJobs(Employee employee) {
        for (Coordinate coordinate : locationRepository.filterCities(employee)) {
            for (Job job : jobRepository.findAll()) {
                if (job.getLocation().contains(coordinate.getLocation().getName())) {
                    System.out.println(job);
                }
            }
        }
    }

    public void printJobList() {
        out.produce("=====================================");
        out.produce("ID Title Hourly_rate Location Company");
        jobRepository.findAll().forEach(job -> out.produce(job.getJobId() + ".   " + job.getTitle() + "    " + job.getHourlyRate()
                + "     " + job.getLocation() + "   " + job.getClient().getCompanyName()));
        out.produce("=====================================");
    }

    public void printClientList() {
        out.produce("================================================");
        out.produce("ID Company_name Company_premises Active_requests");
        clientRepository.findAll().forEach(c -> out.produce(c.getId() + ".   " + c.getCompanyName()
                + "     " + c.getLocation() + "     " + c.getActiveRequests()));
        out.produce("================================================");
    }

    public void printAvailableEmployees() {
        employeeRepository.findAll().stream().filter(Employee::isAvailable)
                .collect(Collectors.toList()).forEach(System.out::println);
    }
}