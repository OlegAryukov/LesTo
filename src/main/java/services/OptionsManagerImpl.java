package services;

import dao.OptionsDAO;
import dao.OptionsDAOImpl;
import model.OptionsEntity;
import org.hibernate.HibernateException;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 25.11.2015.
 */
public class OptionsManagerImpl implements OptionsManager {
    private OptionsDAO optionsDAO = new OptionsDAOImpl();
    public List<OptionsEntity> loadAllOption() {
        List<OptionsEntity> allOptions = new ArrayList<OptionsEntity>();
        try {
            HibernateUtil.beginTransaction();
            allOptions = optionsDAO.findAll(OptionsEntity.class);
            HibernateUtil.commitTransaction();
        }catch (HibernateException ex) {
            System.out.println("Exception hear...");
        }
        return allOptions;
    }

    public void addNewOption(OptionsEntity option) {

    }

    public OptionsEntity findById(Integer id) {
        OptionsEntity option = null;
        try{
            HibernateUtil.beginTransaction();
            option = optionsDAO.findByID(OptionsEntity.class, id);
            HibernateUtil.commitTransaction();
        }catch (HibernateException ex) {
            System.out.println("Handle your error here");
        }
        return option;
    }

    public void deleteOption(OptionsEntity option) {

    }

    public void updateOption(OptionsEntity option) {

    }
}
