package services;

import dao.ContractDAO;
import dao.ContractDAOImpl;
import model.ContractEntity;
import model.OptionsEntity;
import model.TarifEntity;
import org.hibernate.HibernateException;
import util.HibernateUtil;

import java.util.List;

/**
 * Created by oleg on 02.12.2015.
 */
public class ContractManagerImpl implements ContractManager {

    private ContractDAO contractDAO = new ContractDAOImpl();
    public void saveNewContract(ContractEntity contract) {
        try {
            HibernateUtil.beginTransaction();
            contractDAO.save(contract);
            HibernateUtil.commitTransaction();
        }catch (HibernateException ex){
            System.out.println("Sorry...");
            HibernateUtil.rollbackTransaction();
        }

    }

    public ContractEntity findById(Integer id) {
       ContractEntity contract = null;
        try{
            HibernateUtil.beginTransaction();
            contract = contractDAO.findByID(ContractEntity.class, id);
            HibernateUtil.commitTransaction();
        }catch (HibernateException ex) {
            System.out.println("Handle your error here");
        }
        return contract;
    }

    public void deleteContract(ContractEntity contract) {
        try {
            HibernateUtil.beginTransaction();
            contractDAO.delete(contract);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            System.out.println("Handle your error here");
            HibernateUtil.rollbackTransaction();
        }

    }

    public List<OptionsEntity> getConnectedOptions(ContractEntity contract) {
        List<OptionsEntity> set = null;
        try {
            HibernateUtil.beginTransaction();
            set = contract.getConnectionOptions();
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            System.out.println("Herny");
            HibernateUtil.rollbackTransaction();
        }
        return set;
    }

    public void connectOption(OptionsEntity option, ContractEntity contract) {
        try {
            HibernateUtil.beginTransaction();
            ContractEntity contToUpdate = contractDAO.findByID(ContractEntity.class,contract.getContractId());
            List<OptionsEntity> list = contract.getConnectionOptions();
            List<OptionsEntity> avList = contract.getTarifsByContractId().getAvaliableOptions();
            if (list.contains(option)) {

            }else if (avList.contains(option))
             {
                list.add(option);
             }
            contToUpdate.setContractId(contract.getContractId());
            contToUpdate.setClientByClientId(contract.getClientByClientId());
            contToUpdate.setPhoneNum(contract.getPhoneNum());
            contToUpdate.setTarifsByContractId(contract.getTarifsByContractId());
            contToUpdate.setConnectionOptions(list);
            contractDAO.merge(contToUpdate);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            System.out.println("Sorry");
            HibernateUtil.rollbackTransaction();
        }

    }

    public void delitOption(OptionsEntity option, ContractEntity contract) {

        try {
            HibernateUtil.beginTransaction();
            ContractEntity contToUpdate = contractDAO.findByID(ContractEntity.class,contract.getContractId());
            List<OptionsEntity> list = contract.getConnectionOptions();
            OptionsEntity s = null;
            for (OptionsEntity a:list)
            {
                if (option.equals(a))
                    s = a;
            }
            list.remove(s);
            contToUpdate.setContractId(contract.getContractId());
            contToUpdate.setClientByClientId(contract.getClientByClientId());
            contToUpdate.setPhoneNum(contract.getPhoneNum());
            contToUpdate.setTarifsByContractId(contract.getTarifsByContractId());
            contToUpdate.setConnectionOptions(list);
            contractDAO.merge(contToUpdate);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            System.out.println("Sorry");
            HibernateUtil.rollbackTransaction();
        }

    }

    public ContractEntity findByPhone(String phone) {
        ContractEntity contract = null;
        try{
            HibernateUtil.beginTransaction();
            contract = contractDAO.findByPhone(phone);
            HibernateUtil.commitTransaction();
        }catch (HibernateException ex) {
            System.out.println("Handle your error here");
        }
        return contract;
    }

    public void changeTarif(ContractEntity contract, TarifEntity tarif) {
        try {
            HibernateUtil.beginTransaction();
            ContractEntity contToUpdate = contractDAO.findByID(ContractEntity.class,contract.getContractId());
            List<OptionsEntity> list = contract.getConnectionOptions();
            list.clear();
            contToUpdate.setContractId(contract.getContractId());
            contToUpdate.setClientByClientId(contract.getClientByClientId());
            contToUpdate.setPhoneNum(contract.getPhoneNum());
            contToUpdate.setTarifsByContractId(tarif);
            contToUpdate.setConnectionOptions(list);
            contractDAO.merge(contToUpdate);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            System.out.println("Sorry");
            HibernateUtil.rollbackTransaction();
        }

    }

    public List<ContractEntity> findAllByTarifId(TarifEntity tarif) {
        List<ContractEntity> list = null;
        try{
            HibernateUtil.beginTransaction();
            list = contractDAO.findAllContractsByTarifId(tarif);
            HibernateUtil.commitTransaction();
        }catch (HibernateException ex) {
            System.out.println("Handle your error here");
        }
        return list;
    }


}
