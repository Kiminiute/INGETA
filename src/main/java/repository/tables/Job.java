package repository.tables;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Job implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer jobId;
    private String title;
    private String location;
    private Double hourlyRate;
    private LocalDate jobUntil;

    @ManyToOne
    private Client client;

    @OneToMany(mappedBy = "job")
    private List<WorkingEmployee> workingEmployees = new ArrayList<>();

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Integer getJobId() {
        return jobId;
    }

    public void setJobId(Integer jobId) {
        this.jobId = jobId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(Double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public LocalDate getJobUntil() {
        return jobUntil;
    }

    public void setJobUntil(LocalDate jobUntil) {
        this.jobUntil = jobUntil;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId=" + jobId +
                ", title='" + title + '\'' +
                ", location='" + location + '\'' +
                ", hourlyRate=" + hourlyRate +
                ", jobUntil=" + jobUntil +
                '}';
    }
}
