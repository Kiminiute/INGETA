import repository.tables.Coordinate;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        new Project();

        Map<String, Coordinate> miestai = new HashMap<>() {{
            put("Klaipeda", new Coordinate());
        }};

    }
}