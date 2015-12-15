package dao;

import model.ClientEntity;
import org.hibernate.Query;
import util.HibernateUtil;

/**
 * Created by oleg on 25.11.2015.
 */
public class ClientDAOImpl extends CommonDAOImpl<ClientEntity, Integer> implements ClientDAO {
    public ClientEntity findByName(String name, String family) {
        ClientEntity client = null;
        Query query = HibernateUtil.getSession().createQuery("from ClientEntity where name = :name and family = :family").setParameter("name", name).setParameter("family", family);
        client = findOne(query);
        return client;
    }

}
