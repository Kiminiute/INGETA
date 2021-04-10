package repository.tables;



import javax.persistence.*;
import java.io.Serializable;

@Entity
public class WorkingEmployee implements Serializable {
    @Id
    @Column(name = "employee_id")
    private Integer id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Job job;

    @OneToOne
    @MapsId
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getWorkingEmployeeId() {
        return id;
    }

    public void setWorkingEmployeeId(Integer employeeId) {
        this.id = employeeId;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "WorkingEmployee{" +
                "workingEmployeeId=" + id +
                ", client=" + client +
                ", job=" + job +
                '}';
    }
}
