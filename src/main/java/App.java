import repository.tables.Coordinate;
import repository.tables.Employee;

public class App {
    public static void main(String[] args) {
        System.out.println(Employee.class.getSimpleName());
        new Project();
    }
}