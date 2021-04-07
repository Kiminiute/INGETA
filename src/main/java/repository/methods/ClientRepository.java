package repository.methods;

import repository.tables.Client;
import repository_utils.CRUDRepository;
import repository_utils.Repository;

import java.util.List;

public class ClientRepository {
    private final CRUDRepository<Client> repository = new Repository<>(Client.class);

    public Client find(Integer id) { return repository.find(id); }

    public List<Client> findAll() { return repository.findAll(); }

    public void save(Client client) { repository.save(client); }

    public void delete(Client client) { repository.delete(client); }

    public void deleteById(Integer id) { repository.delete(repository.find(id)); }
}
