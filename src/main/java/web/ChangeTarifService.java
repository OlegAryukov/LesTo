package web;

import model.ContractEntity;
import model.TarifEntity;
import services.ContractManager;
import services.ContractManagerImpl;
import services.TarifManager;
import services.TarifManagerImpl;

/**
 * Created by oleg on 03.12.2015.
 */
public class ChangeTarifService {

    public void changeTarif(ContractEntity contract,String tarifId){
        ContractManager cm = new ContractManagerImpl();
        TarifManager tm = new TarifManagerImpl();
        TarifEntity tarif = tm.findById(Integer.parseInt(tarifId));
        cm.changeTarif(contract,tarif);
    }
}
