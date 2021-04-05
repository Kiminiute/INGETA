package controllers;

import repository.tables.Client;
import repository.tables.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AvailableEmployees {


    public List<Employee> getAvailableEmployees(Client client) {
        EmployeeController employeeController = new EmployeeController();
        List<Employee> availableEmployees = new ArrayList<>();
        LocalDate start = client.getJobStart();
        LocalDate finish = client.getJobEnd();

        availableEmployees = employeeController.findAllEmployees()
                .stream()
                .filter(e -> e.getOccupation().equals(client.getOccupation()))
                .filter(e -> e.getLocation().equals(client.getLocation()))
                .collect(Collectors.toList());
        return availableEmployees;
    }
}
