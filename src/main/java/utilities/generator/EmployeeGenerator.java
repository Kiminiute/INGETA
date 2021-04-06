package utilities.generator;

import controllers.EmployeeController;
import repository.tables.Employee;

import java.time.LocalDate;
import java.util.Random;

public class EmployeeGenerator {
    EmployeeController employeeController;
    Random random = new Random();
    private String[] firstNames = {"Jonas", "Giedrius", "Saulius", "Juozas", "Mantas", "Almantas", "Emilis", "Aurimas", "Valentinas", "Benas", "Lukas", "Matas", "Nojus", "Rolandas", "Matas", "Grigalius", "Titas"};
    private String[] lastName = {"Kazlauskas", "Stankevičius", "Petrauskas", "Jankauskas", "Žukauskas", "Butkus", "Balčiūnas", "Paulauskas", "Vasiliauskas", "Baranauskas", "Urbonas", "Navickas", "Ramanauskas", "Savickas", "Rimkus"};
    private String[] city = {"Kaunas","Vilnius","Klaipeda","Siauliai","Silute"};
    private String [] occupation = {"Suvirintojas","Siuvejas","Pagalbinis"};


    public void generateEmployees(int numberOfEmployees) {
        Employee employee = new Employee();
        for (int i = 0; i < numberOfEmployees; i++) {
            employee.setFirstName(firstNames[random.nextInt(firstNames.length)]);
            employee.setLastName(lastName[random.nextInt(lastName.length)]);
            employee.setDateOfBirth(
                    LocalDate.of((LocalDate.now().getYear() - 18 - random.nextInt(40)),
                            1 + random.nextInt(11),
                            1 + random.nextInt(27)));
            employee.setTravelingDistance(20 + random.nextInt(80));
            employee.setLocation(city[random.nextInt(city.length)]);
            employee.setOccupation(occupation[random.nextInt(occupation.length)]);
            employeeController.generateEmployee(employee);
            System.out.println(employee);
        }
    }

}
