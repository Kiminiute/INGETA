package utilities.messages;

import repository.methods.LocationRepository;
import repository.tables.Coordinate;
import repository.tables.Location;
import repository_utils.CRUDRepository;
import repository_utils.Repository;
import utilities.output.OutputProducer;

public class Message {
    private final CRUDRepository<Location> locationRepository = new Repository<>(Location.class);
    private final OutputProducer out = new OutputProducer();

    public void printMainMenu() {
        out.produce("=========== PAGRINDINIS ===========");
        out.produce("Sveiki atvykę į įdarbinimo agentūrą");
        out.produce("1. Darbuotojų meniu");
        out.produce("2. Užsakovų meniu");
        out.produce("0. Baigti programą");
        out.produce("===================================");
    }

    public void printEmployeeMenu() {
        out.produce("==== Darbuotojų meniu ====");
        out.produce("1. Registruoti darbuotoją.");
        out.produce("2. Priimti darbuotoją.");
        out.produce("0. Grįžti į pagrindinį.");
        out.produce("==========================");
    }

    public void printClientMenu() {
        out.produce("1. Pridėti užsakymą.");
        out.produce("2. Atšaukti užsakymą.");
        out.produce("3. Redaguoti užsakymą.");
        out.produce("4. Grįžti į pagrindinį.");
    }

    public void printCityList() {
        for (Location city : locationRepository.findAll()) {
            out.produce(city.getName());
        }
    }
}