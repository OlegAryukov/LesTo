package dao;

import model.OptionsEntity;
import org.hibernate.Query;
import util.HibernateUtil;

/**
 * Created by oleg on 25.11.2015.
 */
public class OptionsDAOImpl extends CommonDAOImpl<OptionsEntity, Integer> implements OptionsDAO {
    public OptionsEntity findByName(String name) {
        OptionsEntity option = null;
        Query query = HibernateUtil.getSession().createQuery("from OptionsEntity where name = :name").setParameter("name", name);
        option = findOne(query);
        return option;
    }

}
