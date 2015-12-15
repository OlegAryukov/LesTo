package web;

import model.ClientEntity;
import model.ContractEntity;
import model.OptionsEntity;
import services.*;

/**
 * Created by oleg on 02.12.2015.
 */
public class AddDelOptionsService {

    ClientManagerImpl clm = new ClientManagerImpl();
    ContractManager cm = new ContractManagerImpl();
    OptionsManager om = new OptionsManagerImpl();
    public void addOption(int contrId, Integer optionId)
    {
        OptionsEntity option = om.findById(optionId);
        ContractEntity contract = cm.findById(contrId);
        cm.connectOption(option,contract);
    }

    public void delOption(int contrId, Integer optionId)
    {
        OptionsEntity option = om.findById(optionId);
        ContractEntity contract = cm.findById(contrId);
        cm.delitOption(option,contract);
    }
    public ClientEntity getClient(Integer clientId){
        ClientEntity client = clm.findById(clientId);
        return client;
    }
}
