package repository.tables;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String age;
    private Double desiredSalary;
    private boolean isAvailable;


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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

//    public Location getLocation() {
//        return location;
//    }
//
//    public void setLocation(Location location) {
//        this.location = location;
//    }

    public Double getDesiredSalary() {
        return desiredSalary;
    }

    public void setDesiredSalary(Double desiredSalary) {
        this.desiredSalary = desiredSalary;
    }

//    public Occupation getOccupation() {
//        return occupation;
//    }
//
//    public void setOccupation(Occupation occupation) {
//        this.occupation = occupation;
//    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
