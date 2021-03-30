package repository.tables;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Coordinate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer coordinateId;
    private Integer x;
    private Integer y;


}
