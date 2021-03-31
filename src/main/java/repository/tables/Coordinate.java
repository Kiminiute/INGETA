package repository.tables;

import javax.persistence.*;

@Entity
public class Coordinate {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "latitude")
    private Float x;

    @Column(name = "longitude")
    private Float y;

    @ManyToOne
    @JoinColumn(name = "city_coordinates")
    private City city_coordinates;
}