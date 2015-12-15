package dao;

import model.ContractEntity;
import model.TarifEntity;

import java.util.List;

/**
 * Created by oleg on 02.12.2015.
 */
public interface ContractDAO extends CommonDAO<ContractEntity, Integer> {
    ContractEntity findByPhone(String phone);
    List<ContractEntity> findAllContractsByTarifId(TarifEntity tarif);
}
