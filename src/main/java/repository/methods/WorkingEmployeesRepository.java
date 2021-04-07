package repository.methods;

import repository.tables.WorkingEmployees;
import repository_utils.CRUDRepository;
import repository_utils.Repository;

public class WorkingEmployeesRepository {
    private final CRUDRepository<WorkingEmployees> repository = new Repository<>(WorkingEmployees.class);



}
