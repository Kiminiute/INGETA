package repository.methods;

import repository.tables.Employee;
import repository_utils.Repository;

import java.util.List;

public class EmployeeRepository {
    private final Repository<Employee> repository = new Repository<>(Employee.class);

    public Employee find(Integer id) { return repository.find(id); }

    public List<Employee> findAll() { return repository.findAll(); }

    public void save(Employee employee) { repository.save(employee); }

    public void delete(Employee employee) { repository.delete(employee); }

    public void deleteById(Integer id) { repository.delete(repository.find(id)); }

    public void displayEmployees() {
        repository.findAll().forEach(e -> System.out.println(e.toString()));
    }
}
