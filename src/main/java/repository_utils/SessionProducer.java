package repository_utils;

import hibernate_utils.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class SessionProducer {
    private final SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
    private final Session session = sessionFactory.openSession();

    public Session produceSession() {
        return session;
    }
}
