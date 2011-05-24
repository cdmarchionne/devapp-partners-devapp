package ar.edu.unq.partnersdevapp;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {

    private static final SessionFactory SESSIONFACTORY = buildSessionFactory();

    private static synchronized SessionFactory buildSessionFactory() {
        return new Configuration().configure().buildSessionFactory();
    }

    public static synchronized SessionFactory getSessionFactory() {
        return SESSIONFACTORY;
    }

}
