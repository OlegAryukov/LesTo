package dao;

import model.OptionsEntity;

/**
 * Created by oleg on 25.11.2015.
 */
public interface OptionsDAO extends CommonDAO<OptionsEntity, Integer> {
    OptionsEntity findByName(String name);

}
