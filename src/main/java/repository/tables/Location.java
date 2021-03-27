package repository.tables;

import javax.persistence.Entity;

@Entity
public class Location {
    private String name;
    private Coordinate coords;
}
