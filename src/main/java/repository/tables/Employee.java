package repository.tables;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Employee implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer id;
    private String firstName;
    private String lastName;
    private String age;
    private String city;
    private Double distanceToWork;

    @OneToOne
    private Location location;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private WorkingEmployee workingEmployee;

    public Integer getId() {
        return id;
    }

    public void setId(Integer employeeId) {
        this.id = employeeId;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getDistanceToWork() {
        return distanceToWork;
    }

    public boolean isAvailable() {
        return workingEmployee == null;
    }

    public void setDistanceToWork(Double distanceToWork) {
        this.distanceToWork = distanceToWork;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public WorkingEmployee getWorkingEmployee() {
        return workingEmployee;
    }

    public void setWorkingEmployee(WorkingEmployee workingEmployee) {
        this.workingEmployee = workingEmployee;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", city='" + city + '\'' +
                ", distanceToWork=" + distanceToWork +
                ", location=" + location +
                ", workingEmployee=" + workingEmployee +
                '}';
    }
}
