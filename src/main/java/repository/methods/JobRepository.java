package repository.methods;

import repository.tables.Job;
import repository_utils.CRUDRepository;
import repository_utils.Repository;

import java.util.List;

public class JobRepository {
    private final CRUDRepository<Job> jobRepository = new Repository<>(Job.class);

    public Job find(Integer id) { return jobRepository.find(id); }

    public List<Job> findAll() { return jobRepository.findAll(); }

    public void save(Job job) { jobRepository.save(job); }

    public void delete(Job job) { jobRepository.delete(job); }

    public void deleteById(Integer id) { jobRepository.delete(jobRepository.find(id)); }


}
