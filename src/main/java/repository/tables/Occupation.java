package repository.tables;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Occupation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer occupationId;
    private String jobTitle;
    private Double salary;
}
