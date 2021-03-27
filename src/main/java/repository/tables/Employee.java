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

}
