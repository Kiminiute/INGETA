package controllers;

import repository.tables.Client;
import repository.tables.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AvailableEmployees {
    EmployeeController employeeController = new EmployeeController();
    WorkingEmployeesController workingEmployeesController = new WorkingEmployeesController();


    public List<Employee> getAvailableEmployees(Client client) {
        List<Employee> availableEmployees = employeeController.findAllEmployees()
                .stream()
                .filter(e -> e.getOccupation().equalsIgnoreCase(client.getOccupation()))
                .filter(e -> e.getLocation().equalsIgnoreCase(client.getLocation()))
                .collect(Collectors.toList());
        List<Employee> workingEmployees = workingEmployeesController
                .getWorkingEmployees(client.getJobStart(), client.getJobEnd());
        for (Employee e : workingEmployees) {
            availableEmployees.remove(e);
        }
        return availableEmployees;
    }
}
