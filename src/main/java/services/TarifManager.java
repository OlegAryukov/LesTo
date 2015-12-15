package services;

import model.OptionsEntity;
import model.TarifEntity;

import java.util.List;

/**
 * Created by oleg on 02.12.2015.
 */
public interface TarifManager {
   // public ClientEntity findByPersonName(String name, String family);

    public List<TarifEntity> loadAlltarif();

    public void saveNewTrif(TarifEntity tarif);

    public TarifEntity findById(Integer id);

    public void deleteTarif(TarifEntity tarif, TarifEntity tarifOnChange);

    public List<OptionsEntity> getAvaliableOptions(TarifEntity tarif);
}
