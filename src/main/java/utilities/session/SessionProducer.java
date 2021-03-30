package utilities.session;

import hibernate_utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SessionProducer {
    private static final SessionFactory sf = HibernateUtils.getSessionFactory();
    private static final Session session = sf.openSession();

    public Session produceSession() {
        return session;
    }
}
