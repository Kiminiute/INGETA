package repository.methods;

import repository.tables.Employee;
import repository_utils.Repository;

import java.util.List;

public class EmployeeRepository {
    private static final Repository<Employee> repository = new Repository<>(Employee.class);

    public static Employee findEmployee(Integer id) {
        return repository.find(id);
    }

    public static List<Employee> findAllEmployees() {
        return repository.findAll();
    }

    public static void deleteEmployee(Employee employee) {
        repository.delete(employee);
    }

    public static void deleteEmployeeById(Integer id) {
        repository.delete(repository.find(id));
    }


}
