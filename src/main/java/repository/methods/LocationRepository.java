package repository.methods;

import repository.tables.Coordinate;
import repository.tables.Location;
import repository_utils.CRUDRepository;
import repository_utils.Repository;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LocationRepository {
    private final CRUDRepository<Location> locationRepository = new Repository<>(Location.class);
    private final CRUDRepository<Coordinate> coordinateRepository = new Repository<>(Coordinate.class);

    public Location find(Integer id) { return locationRepository.find(id); }

    public List<Location> findAll() { return locationRepository.findAll(); }

    public void save(Location location) { locationRepository.save(location); }

    public void delete(Location location) { locationRepository.delete(location); }

    public void deleteById(Integer id) { locationRepository.delete(locationRepository.find(id)); }

    public Map<String, Coordinate> getLocations() {
        Map<String, Coordinate> cities = new HashMap<>();
        cities.put("Vilnius", new Coordinate(54.687157, 25.279652));
        cities.put("Alytus", new Coordinate(54.395432, 24.046780));
        cities.put("Anykščiai", new Coordinate(55.535069, 25.086180));
        cities.put("Biržai", new Coordinate(56.204861, 24.760180));
        cities.put("Druskininkai", new Coordinate(54.015339, 23.978411));
        cities.put("Ignalina", new Coordinate(55.342800, 26.164780));
        cities.put("Jonava", new Coordinate(55.0788591, 24.2668109));
        cities.put("Joniškis", new Coordinate(56.2343623, 23.5960764));
        cities.put("Jurbarkas", new Coordinate(55.0801088, 22.724254));
        cities.put("Kaunas", new Coordinate(54.8898944, 23.7871825));
        cities.put("Kėdainiai", new Coordinate(55.2983804, 23.9132163));
        cities.put("Klaipėda", new Coordinate(55.7052607, 21.0178116));
        cities.put("Kretinga", new Coordinate(55.8799312, 21.1999012));
        cities.put("Kupiškis", new Coordinate(55.8366107, 24.9625221));
        cities.put("Lazdijai", new Coordinate(54.2302564, 23.4777817));
        cities.put("Marijampolė", new Coordinate(54.5418177, 23.2731648));
        cities.put("Mažeikiai", new Coordinate(56.3135181, 22.2973123));
        cities.put("Molėtai", new Coordinate(55.2252378, 25.4014829));
        cities.put("Naujoji Akmenė", new Coordinate(56.3145333, 22.8687526));
        cities.put("Nida", new Coordinate(55.3105002, 20.9861444));
        cities.put("Pakruojis", new Coordinate(55.9870591, 23.8276123));
        cities.put("Palanga", new Coordinate(55.9660677, 20.9541985));
        cities.put("Panevėžys", new Coordinate(55.730411, 24.2641982));
        cities.put("Pasvalys", new Coordinate(56.0598597, 24.3787844));
        cities.put("Plungė", new Coordinate(55.9131042, 21.810025));
        cities.put("Prienai", new Coordinate(54.6356649, 23.9203487));
        cities.put("Radviliškis", new Coordinate(55.8124826, 23.5113992));
        cities.put("Rokiškis", new Coordinate(55.958214, 25.5514777));
        cities.put("Skuodas", new Coordinate(56.2706152, 21.499641));
        cities.put("Šakiai", new Coordinate(54.9479345, 23.0274435));
        cities.put("Šalčininkai", new Coordinate(54.3098738, 25.37026));
        cities.put("Šiauliai", new Coordinate(55.9062544, 23.2583324));
        cities.put("Šilalė", new Coordinate(55.4932822, 22.1669265));
        cities.put("Šilutė", new Coordinate(55.348715, 21.4328428));
        cities.put("Švenčionys", new Coordinate(55.1260538, 26.1520991));
        cities.put("Tauragė", new Coordinate(55.2516753, 22.2555611));
        cities.put("Telšiai", new Coordinate(55.9785486, 22.1960607));
        cities.put("Trakai", new Coordinate(54.6429508, 24.8933233));
        cities.put("Ukmergė", new Coordinate(55.2392864, 24.7357503));
        cities.put("Utena", new Coordinate(55.501504, 25.5732257));
        cities.put("Varėna", new Coordinate(54.2243999, 24.5433852));
        cities.put("Vilkaviškis", new Coordinate(54.6513052, 23.0178271));
        cities.put("Visaginas", new Coordinate(55.5972882, 26.4144968));
        cities.put("Zarasai", new Coordinate(55.7303515, 26.2100586));
        return cities;
    }

    public void initializeLocationsToRepo() {
        for(Map.Entry<String, Coordinate> location : getLocations().entrySet()) {
            Location locationInit = new Location();
            locationInit.setName(location.getKey());
            locationRepository.save(locationInit);
            location.getValue().setLocation(locationInit);
            coordinateRepository.save(location.getValue());
        }
    }

}
