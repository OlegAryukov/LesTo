package dao;

import model.ContractEntity;
import model.TarifEntity;
import org.hibernate.Query;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by oleg on 02.12.2015.
 */
public class ContractDAOImpl extends CommonDAOImpl<ContractEntity, Integer> implements ContractDAO {

    public ContractEntity findByPhone(String phone) {
        ContractEntity contract = null;
        Query query = HibernateUtil.getSession().createQuery("from ContractEntity where phoneNum = :number").setParameter("number", phone);
        contract = findOne(query);
        return contract;
    }

    public List<ContractEntity> findAllContractsByTarifId(TarifEntity tarif) {
        List<ContractEntity> list = null;
        //String tarif = Integer.toString(tarifId);
        Query query = HibernateUtil.getSession().createQuery("from ContractEntity where tarifsByContractId = :tarif").setParameter("tarif", tarif);
        list = findMany(query);
        return list;
    }
}
