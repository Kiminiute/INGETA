package hibernate_utils;

import database_utils.DatabaseUtils;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import repository.tables.*;

import java.util.Properties;

public class HibernateUtils {

    private static SessionFactory sessionFactory;
    public static SessionFactory getSessionFactory() {
        if(sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();
                Properties settings = new Properties();
                settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
                settings.put(Environment.URL, DatabaseUtils.DATABASE_HOST);
                settings.put(Environment.USER, DatabaseUtils.DATABASE_USERNAME);
                settings.put(Environment.PASS, DatabaseUtils.DATABASE_PASSWORD);
                settings.put(Environment.HBM2DDL_AUTO, "create-drop");
                settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
                settings.put(Environment.SHOW_SQL, "true");
                configuration.setProperties(settings);
                configuration.addAnnotatedClass(Employee.class)
                        .addAnnotatedClass(Client.class)
                        .addAnnotatedClass(Coordinate.class)
                        .addAnnotatedClass(Occupation.class)
                        .addAnnotatedClass(WorkingEmployees.class)
                        .addAnnotatedClass(Location.class);
                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().
                        applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}
