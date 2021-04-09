package repository.methods;

import repository.tables.WorkingEmployee;
import repository_utils.CRUDRepository;
import repository_utils.Repository;

import java.util.List;

public class WorkingEmployeeRepository {
    private final CRUDRepository<WorkingEmployee> repository = new Repository<>(WorkingEmployee.class);

    public WorkingEmployee find(Integer id) { return repository.find(id); }

    public List<WorkingEmployee> findAll() { return repository.findAll(); }

    public void save(WorkingEmployee workingEmployee) { repository.save(workingEmployee); }

    public void delete(WorkingEmployee workingEmployee) { repository.delete(workingEmployee); }

    public void deleteById(Integer id) { repository.delete(repository.find(id)); }


}
