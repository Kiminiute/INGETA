package repository.tables;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String occupation;
    private int travelingDistance;

    @Override
    public String toString() {
        return "Employee{" +
                "Id=" + employeeId +
                ", Vardas='" + firstName + '\'' +
                ", Pavardė='" + lastName + '\'' +
                ", Gimino Data=" + dateOfBirth +
                ", Specialybė=" + occupation +
                ", Keliaujamas atstumas=" + travelingDistance +
                ", Vieta=" + location +
                '}';
    }

    public Employee(String firstName, String lastName, LocalDate dateOfBirth, String occupation, int travelingDistance, Location location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.occupation = occupation;
        this.travelingDistance = travelingDistance;
        this.location = location;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getTravelingDistance() {
        return travelingDistance;
    }

    public void setTravelingDistance(int travelingDistance) {
        this.travelingDistance = travelingDistance;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Employee() {
    }

    @JoinTable(name = "employees_locations",
    joinColumns = @JoinColumn(name = "employeeId"),
    inverseJoinColumns = @JoinColumn(name = "locationId"))
    @OneToOne(mappedBy = "employee")

    private Location location;




//    private Location location;

//    private Occupation occupation;


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

//    public Location getLocation() {
//        return location;
//    }
//
//    public void setLocation(Location location) {
//        this.location = location;
//    }

//    public Occupation getOccupation() {
//        return occupation;
//    }
//
//    public void setOccupation(Occupation occupation) {
//        this.occupation = occupation;
//    }


}
