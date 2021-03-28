package repository.tables;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Employee {
    private String firstName;
    private String lastName;
    private LocalDate age;
    private Location location;
    private Double desiredSalary;
    private Occupation occupation;
    private boolean isAvailable;


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

    public LocalDate getAge() {
        return age;
    }

    public void setAge(LocalDate age) {
        this.age = age;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Double getDesiredSalary() {
        return desiredSalary;
    }

    public void setDesiredSalary(Double desiredSalary) {
        this.desiredSalary = desiredSalary;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
