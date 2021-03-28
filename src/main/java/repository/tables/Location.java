package repository.tables;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Location {
    @Id
    private Integer id;
    private String name;
    private Coordinate coords;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinate getCoords() {
        return coords;
    }

    public void setCoords(Coordinate coords) {
        this.coords = coords;
    }
}
