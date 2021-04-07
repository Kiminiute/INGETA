package repository.tables;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class WorkingEmployees implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name="increment", strategy = "increment")
    private Integer workingEmployeeId;
    private LocalDate jobStart;
    private LocalDate jobEnd;
    private boolean isAvailable;


}
