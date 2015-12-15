package services;

import model.OptionsEntity;

import java.util.List;

/**
 * Created by oleg on 25.11.2015.
 */
public interface OptionsManager {

    public List<OptionsEntity> loadAllOption();

    public void addNewOption(OptionsEntity option);

    public OptionsEntity findById(Integer id);

    public void deleteOption(OptionsEntity option);

    public void updateOption(OptionsEntity option);
}
