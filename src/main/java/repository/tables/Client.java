package repository.tables;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer id;
    private String companyName;
//    private Location location;
//    private LocalDate jobStart;
//    private LocalDate jobEnd;
//    private Occupation jobs;

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

//    public Location getLocation() {
//        return location;
//    }
//
//    public void setLocation(Location location) {
//        this.location = location;
//    }
//
//    public LocalDate getJobStart() {
//        return jobStart;
//    }
//
//    public void setJobStart(LocalDate jobStart) {
//        this.jobStart = jobStart;
//    }
//
//    public LocalDate getJobEnd() {
//        return jobEnd;
//    }
//
//    public void setJobEnd(LocalDate jobEnd) {
//        this.jobEnd = jobEnd;
//    }
//
//    public Occupation getJobs() {
//        return jobs;
//    }
//
//    public void setJobs(Occupation jobs) {
//        this.jobs = jobs;
//    }
}
