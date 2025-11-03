package lk.jiat.webii.hp.util;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;

public class HibernateUtil {
    private static final SessionFactory sessionFactory;
    static {
        try {
            sessionFactory = new org.hibernate.cfg.Configuration()
                    .configure()
                    .buildSessionFactory();
        }catch (HibernateException e){
            throw new ExceptionInInitializerError("Session Factory Creation Failed" +e.getMessage());
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void shutdown(){
        sessionFactory.close();
    }

}
