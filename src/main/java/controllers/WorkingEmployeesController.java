package controllers;

import repository.tables.Client;
import repository.tables.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WorkingEmployeesController {
    ClientController clientController = new ClientController();


    public List<Employee> getWorkingEmployees(LocalDate start, LocalDate finish) {
        List<Employee> workingEmployees = new ArrayList<>();
        List<Client> clientList = clientController.getClientList()
                .stream()
                .filter(c -> c.getJobStart().isAfter(start) && c.getJobStart().isBefore(finish) ||
                        c.getJobEnd().isAfter(start) && c.getJobEnd().isBefore(finish))
                .collect(Collectors.toList());

        for (Client c : clientList) {
            workingEmployees.add(c.getEmployee());
        }
        return workingEmployees;
    }


}
