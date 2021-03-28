package utils;

import hibernate_utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import repository.tables.Location;

public class EmployeeDao {

    private void createEmployee() {
        SessionFactory sf = HibernateUtils.getSessionFactory(Location.class);
        Session session = sf.openSession();
        session.beginTransaction();
        Location location = new Location();
        location.setId(10);
        location.setName("aaa");
        session.save(location);
        session.close();
    }
}
