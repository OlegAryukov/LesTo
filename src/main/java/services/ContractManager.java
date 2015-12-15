package services;

import model.ContractEntity;
import model.OptionsEntity;
import model.TarifEntity;

import java.util.List;

/**
 * Created by oleg on 02.12.2015.
 */
public interface ContractManager {

    public void saveNewContract(ContractEntity contract);

    public ContractEntity findById(Integer id);

    public void deleteContract (ContractEntity contract);

    public List<OptionsEntity> getConnectedOptions(ContractEntity contract);

    public void connectOption(OptionsEntity option, ContractEntity contract);

    public void delitOption(OptionsEntity option, ContractEntity contract);

    public ContractEntity findByPhone(String phone);

    public void changeTarif(ContractEntity contract, TarifEntity tarif);

    List<ContractEntity> findAllByTarifId(TarifEntity tarif);
}
