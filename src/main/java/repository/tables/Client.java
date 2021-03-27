package repository.tables;

import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
public class Client {
    private String companyName;
    private Location location;
    private LocalDate jobStart;
    private LocalDate jobEnd;
    private Occupation jobs;



}
