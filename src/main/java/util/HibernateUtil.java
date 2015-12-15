package util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by oleg on 21.11.2015.
 */
public class HibernateUtil {
   /* private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new AnnotationConfiguration().configure().buildSessionFactory();

        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        // Close caches and connection pools
        getSessionFactory().close();
    }*/
    private static final SessionFactory sessionFactory;

    static {
        try{
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }catch (Throwable ex){
            System.err.println("Init SessionFactory creation filed" + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    private static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static Session beginTransaction(){
        Session hibernateSession = HibernateUtil.getSession();
        hibernateSession.beginTransaction();
        return hibernateSession;
    }
    public static void commitTransaction(){
        HibernateUtil.getSession().getTransaction().commit();
    }

    public static void rollbackTransaction(){
        HibernateUtil.getSession().getTransaction().rollback();
    }

    public static void closeSession(){
        HibernateUtil.getSession().close();
    }

    public static Session getSession(){
        Session hiberanateSession = sessionFactory.getCurrentSession();
        return hiberanateSession;
    }
}
