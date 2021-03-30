package repository.tables;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

public class WorkingEmployees {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer workingEmployeeId;
//    private Employee employee;
    private LocalDate jobStart;
    private LocalDate jobEnd;

}
