package repository.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Client implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String companyName;
    private String location;
    private LocalDate jobStart;
    private LocalDate jobEnd;
    private String occupation;
    private double hourlyRate;

    public Client() {
    }

    public Client(String companyName, String location, LocalDate jobStart, LocalDate jobEnd, String occupation, double hourlyRate) {
        this.companyName = companyName;
        this.location = location;
        this.jobStart = jobStart;
        this.jobEnd = jobEnd;
        this.occupation = occupation;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", location='" + location + '\'' +
                ", jobStart=" + jobStart +
                ", jobEnd=" + jobEnd +
                ", occupation='" + occupation + '\'' +
                ", hourlyRate=" + hourlyRate +
                '}';
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

    public LocalDate getJobStart() {
        return jobStart;
    }

    public void setJobStart(LocalDate jobStart) {
        this.jobStart = jobStart;
    }

    public LocalDate getJobEnd() {
        return jobEnd;
    }

    public void setJobEnd(LocalDate jobEnd) {
        this.jobEnd = jobEnd;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }
}

