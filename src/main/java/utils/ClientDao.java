package utils;

import hibernate_utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.tables.Client;

public class ClientDao {

    public void addClient() {
        SessionFactory sf = HibernateUtils.getSessionFactory(Client.class);
        Session session = sf.openSession();
        session.beginTransaction();
        session.save(new Client());

    }

    public void removeClient() {

    }
}
