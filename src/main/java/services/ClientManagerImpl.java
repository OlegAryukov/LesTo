package services;

import dao.ClientDAO;
import dao.ClientDAOImpl;
import model.ClientEntity;
import model.ContractEntity;
import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by oleg on 25.11.2015.
 */
public class ClientManagerImpl implements ClientManager {

    private ClientDAO clientDAO = new ClientDAOImpl();
    public ClientEntity findByPersonName(String name, String family) {
        ClientEntity client = null;
        try {
            HibernateUtil.beginTransaction();
            client = clientDAO.findByName(name, family);
            HibernateUtil.commitTransaction();
        } catch (NonUniqueResultException ex) {
            System.out.println("Handle your error here");
            System.out.println("Query returned more than one results.");
        } catch (HibernateException ex) {
            System.out.println("Handle your error here");
        }
        return client;
    }

    public List<ClientEntity> loadAllClient() {
        List<ClientEntity> allClient = new ArrayList<ClientEntity>();
        try {
            HibernateUtil.beginTransaction();
            allClient = clientDAO.findAll(ClientEntity.class);
            HibernateUtil.commitTransaction();
        }catch (HibernateException ex) {
            System.out.println("Exception hear...");
        }
        return allClient;
    }



    public void saveNewClient(ClientEntity client) {
        try {
            HibernateUtil.beginTransaction();
            clientDAO.save(client);
            HibernateUtil.commitTransaction();
        }catch (HibernateException ex){
            System.out.println("Sorry...");
            HibernateUtil.rollbackTransaction();
        }

    }

    public ClientEntity findById(Integer id) {
        ClientEntity client = null;
        try{
            HibernateUtil.beginTransaction();
            client = clientDAO.findByID(ClientEntity.class, id);
            HibernateUtil.commitTransaction();
        }catch (HibernateException ex) {
            System.out.println("Handle your error here");
        }
        return client;
    }

    public void deleteClient(ClientEntity client) {
        try {
            HibernateUtil.beginTransaction();
            clientDAO.delete(client);
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            System.out.println("Handle your error here");
            HibernateUtil.rollbackTransaction();
        }
    }

    public List<ContractEntity> getAllContracts(ClientEntity client) {
        List<ContractEntity> set = null;
        try {
            HibernateUtil.beginTransaction();
            set = client.getContractsByClientId();
            HibernateUtil.commitTransaction();
        } catch (HibernateException ex) {
            System.out.println("Herny");
            HibernateUtil.rollbackTransaction();
        }
        return set;

    }



}
