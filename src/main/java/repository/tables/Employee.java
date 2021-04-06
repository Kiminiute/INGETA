package repository.tables;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.util.Set;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name = "increment", strategy = "increment")
    private Integer employeeId;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String occupation;

    @OneToMany(mappedBy = "employee")
    private Set<Client> clients;
    private int travelingDistance;
//    @JoinTable(name = "employees_locations",
//            joinColumns = @JoinColumn(name = "employeeId"),
//            inverseJoinColumns = @JoinColumn(name = "locationId"))
//    @OneToOne
    private String location;

    public Employee() {
    }

    public Employee(String firstName, String lastName, LocalDate dateOfBirth, String occupation, int travelingDistance, String location) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.occupation = occupation;

        this.travelingDistance = travelingDistance;
        this.location = location;
    }

    public Set<Client> getClients() {
        return clients;
    }

    public void setClients(Set<Client> clients) {
        this.clients = clients;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public int getTravelingDistance() {
        return travelingDistance;
    }

    public void setTravelingDistance(int travelingDistance) {
        this.travelingDistance = travelingDistance;
    }

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

    @Override
    public String toString() {
        return String.format("Darbuotojo ID-[%d] %s %s %s %s [%s] ",
        employeeId,
        firstName,
        lastName,
        dateOfBirth,
        location,
        occupation
        );


    }
}
