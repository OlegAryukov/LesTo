package services;

import dao.TarifDAO;
import dao.TarifDAOImpl;
import model.OptionsEntity;
import model.TarifEntity;
import org.hibernate.HibernateException;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 03.12.2015.
 */
public class TarifManagerImpl implements TarifManager {

    private TarifDAO  tarifDAO = new TarifDAOImpl();


    public List<TarifEntity> loadAlltarif() {
        List<TarifEntity> allTraif = new ArrayList<TarifEntity>();
        try {
            HibernateUtil.beginTransaction();
            allTraif = tarifDAO.findAll(TarifEntity.class);
            HibernateUtil.commitTransaction();
        }catch (HibernateException ex) {
            System.out.println("Exception hear...");
        }
        return allTraif;
    }

    public void saveNewTrif(TarifEntity tarif) {
        try {
            HibernateUtil.beginTransaction();
            tarifDAO.save(tarif);
            HibernateUtil.commitTransaction();
        }catch (HibernateException ex){
            System.out.println("Sorry...");
            HibernateUtil.rollbackTransaction();
        }
    }

    public TarifEntity findById(Integer id) {
        TarifEntity tarif = null;
        try{
            HibernateUtil.beginTransaction();
            tarif = tarifDAO.findByID(TarifEntity.class, id);
            HibernateUtil.commitTransaction();
        }catch (HibernateException ex) {
            System.out.println("Handle your error here");
        }
        return tarif;
    }

    public void deleteTarif(TarifEntity tarif, TarifEntity tarifOnChange) {
        try{
            HibernateUtil.beginTransaction();

            HibernateUtil.commitTransaction();
        }catch (HibernateException ex) {
            System.out.println("Handle your error here");
        }
    }

    public List<OptionsEntity> getAvaliableOptions(TarifEntity tarif) {
        return null;
    }
}
