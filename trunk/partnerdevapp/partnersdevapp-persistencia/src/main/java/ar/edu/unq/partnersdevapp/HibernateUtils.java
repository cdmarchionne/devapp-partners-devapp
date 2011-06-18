package ar.edu.unq.partnersdevapp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    // private static final HibernateUtils INSTANCE = new HibernateUtils();
    @SuppressWarnings("PMD")
    private static final SessionFactory SESSIONFACTORY = buildSessionFactory();

    private HibernateUtils() {
        super();
    }

    // public static HibernateUtils getInstance() {
    // synchronized (INSTANCE) {
    // return INSTANCE;
    // }
    // }

    private static SessionFactory buildSessionFactory() {
        synchronized (SESSIONFACTORY) {
            return new Configuration().configure().buildSessionFactory();
        }
    }

    public static SessionFactory getSessionFactory() {
        synchronized (SESSIONFACTORY) {
            return SESSIONFACTORY;
        }
    }

}
