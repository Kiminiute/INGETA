package repository.methods;

import repository.tables.Coordinate;
import repository.tables.Employee;
import repository_utils.CRUDRepository;
import repository_utils.Repository;


public class CoordinateRepository {
    private final CRUDRepository<Coordinate> repository = new Repository<>(Coordinate.class);

    public boolean isLocationValid(final String location) {
        for (Coordinate coord : repository.findAll()) {
            if (coord.getLocation().getName().equalsIgnoreCase(location)) {
                return true;
            }
        }
        return false;
    }

    public Double calculateDistance(Coordinate c1, Coordinate c2) {
        final int R = 6371;

        double latDistance = Math.toRadians(c2.getLatitude() - c1.getLatitude());
        double lonDistance = Math.toRadians(c2.getLongitude() - c1.getLongitude());
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(c1.getLatitude())) * Math.cos(Math.toRadians(c2.getLatitude()))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c;

        distance = Math.pow(distance, 2);

        return Math.sqrt(distance);
    }
}