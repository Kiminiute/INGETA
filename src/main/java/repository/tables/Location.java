package repository.tables;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer locationId;
    private Integer employeeId;
    private String name;

    @OneToOne
    private Employee employee;

    public Integer getLocationId() {
        return locationId;
    }

    public void setLocationId(Integer id) {
        this.locationId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Coordinate getCoords() {
//        return coords;
//    }
//
//    public void setCoords(Coordinate coords) {
//        this.coords = coords;
//    }
}
