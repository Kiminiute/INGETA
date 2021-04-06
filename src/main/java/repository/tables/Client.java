package repository.tables;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String companyName;
    private String location;
    private LocalDate jobStart;
    private LocalDate jobEnd;
    private String occupation;
    private double hourlyRate;
    @ManyToOne
    @JoinColumn(name="employeeID")
    private Employee employee;

    public Client() {
    }

    public Client(String companyName, String location, LocalDate jobStart, LocalDate jobEnd, String occupation, double hourlyRate, Employee employee) {
        this.companyName = companyName;
        this.location = location;
        this.jobStart = jobStart;
        this.jobEnd = jobEnd;
        this.occupation = occupation;
        this.hourlyRate = hourlyRate;
        this.employee = employee;
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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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

