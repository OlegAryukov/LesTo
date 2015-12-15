package web;

/**
 * Created by oleg on 30.11.2015.
 */

import model.ClientEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import util.HibernateUtil;

public class LoginService {
    //ClientManager cm = new ClientManagerImpl();

    public boolean authenticateUser(String userEmail, String password) {
        ClientEntity user = getUserByUserId(userEmail);
        if(user!=null && user.getEmail().equals(userEmail) && user.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }

    public ClientEntity getUserByUserId(String userEmail) {
        Session session = HibernateUtil.getSession();

        ClientEntity user = null;
        try {
            session.beginTransaction();
            Query query = session.createQuery("from ClientEntity where email='"+userEmail+"'");
            user = (ClientEntity)query.uniqueResult();
            //session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }

    /*public List<User> getListOfUsers(){
        List<User> list = new ArrayList<User>();
        Session session = HibernateUtil.openSession();
        Transaction tx = null;
        try {
            tx = session.getTransaction();
            tx.begin();
            list = session.createQuery("from User").list();
            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }*/
}
