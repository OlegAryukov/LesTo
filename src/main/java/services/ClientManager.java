package services;

import model.ClientEntity;
import model.ContractEntity;

import java.util.List;

/**
 * Created by oleg on 25.11.2015.
 */
public interface ClientManager {
    public ClientEntity findByPersonName(String name, String family);

    public List<ClientEntity> loadAllClient();

    public void saveNewClient(ClientEntity client);

    public ClientEntity findById(Integer id);

    public void deleteClient(ClientEntity client);

    public List<ContractEntity> getAllContracts(ClientEntity client);

}
