package controllers;

import repository.methods.ClientRepository;
import repository.methods.CoordinateRepository;
import repository.methods.JobRepository;
import repository.methods.LocationRepository;
import repository.tables.Client;
import repository.tables.Job;
import utilities.date.Date;
import utilities.input.InputReceiver;
import utilities.output.OutputProducer;

public class ClientController {
    private final InputReceiver in = new InputReceiver();
    private final OutputProducer out = new OutputProducer();
    private final ClientRepository clientRepository = new ClientRepository();
    private final LocationRepository locationRepository = new LocationRepository();
    private final CoordinateRepository coordinateRepository = new CoordinateRepository();
    private final JobRepository jobRepository = new JobRepository();

    public void addJob() {
        Job job = new Job();
        out.produce("=== Darbo skelbimo registracija ===");
        out.produce("Kliento ID: ");
        Client client = clientRepository.find(in.receiveLine().nextInt());
        out.produce("Darbo pavadinimas: ");
        job.setTitle(in.receiveLine().next());
        out.produce("Darbo vieta (miestas): ");
        String city = in.receiveLine().next();
        if(locationRepository.isLocationValid(city)) {
            job.setLocation(city);
        } else {
            out.produceErr("Miestas neegzistuoja, bandykite is naujo");
            addJob();
        }
        out.produce("Siulomas valandinis atlygis: ");
        job.setHourlyRate(in.receiveLine().nextDouble());
        out.produce("Darbas iki yyyy-mm-dd: ");
        String date = in.receiveLine().next();
        if(Date.isDateValid(date)) {
            job.setJobUntil(Date.toLocalDate(date));
        } else {
            out.produceErr("Data neteisinga, prašome bandyti iš naujo");
        }
        job.setClient(client);
        jobRepository.save(job);
        client.getJob().add(job);
        client.setActiveRequests(client.getActiveRequests() + 1);
        clientRepository.save(client);
        out.produce("Darbas sekmingai sukurtas!");
    }

    public void addClient() {
        Client client = new Client();
        out.produce("=== KLIENTO REGISTRACIJA === ");
        out.produce("Įmonės pavadinimas: ");
        client.setCompanyName(in.receiveLine().next());
        out.produce("Įmonė įsikŪrusi (miestas): ");
        String city = in.receiveLine().next();
        if(locationRepository.isLocationValid(city)) {
            client.setLocation(city);
        } else {
            out.produceErr("Miestas neegzistuoja, bandykite iš naujo");
            addClient();
        }
        clientRepository.save(client);
    }

    public void removeRequest(Integer id) {
        out.produce("=== Uzsakymo atsaukimas ===");
        out.produce("Darbo skelbimo ID:");
        jobRepository.deleteById(id);
        out.produce("Uzsakymas atsauktas sekmingai!");
    }
}
