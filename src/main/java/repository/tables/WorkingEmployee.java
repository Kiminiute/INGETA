package repository.tables;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class WorkingEmployee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer workingEmployeeId;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Job job;


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getWorkingEmployeeId() {
        return workingEmployeeId;
    }

    public void setWorkingEmployeeId(Integer workingEmployeeId) {
        this.workingEmployeeId = workingEmployeeId;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "WorkingEmployee{" +
                "workingEmployeeId=" + workingEmployeeId +
                ", client=" + client +
                ", job=" + job +
                '}';
    }
}
