package repository.tables;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;
    private String companyName;
    private String location;
    private Integer activeRequests = 0;

    public Client() {
    }

    public Client(String companyName, String location) {
        this.companyName = companyName;
        this.location = location;
    }

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<Job> job = new ArrayList<>();

    @OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
    private List<WorkingEmployee> workingEmployees = new ArrayList<>();

    public List<WorkingEmployee> getWorkingEmployees() {
        return workingEmployees;
    }

    public void setWorkingEmployees(List<WorkingEmployee> workingEmployees) {
        this.workingEmployees = workingEmployees;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getActiveRequests() {
        return activeRequests;
    }

    public void setActiveRequests(Integer activeRequests) {
        this.activeRequests = activeRequests;
    }

    public List<Job> getJob() {
        return job;
    }

    public void setJob(List<Job> job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", location='" + location + '\'' +
                ", activeRequests=" + activeRequests +
                '}';
    }
}

