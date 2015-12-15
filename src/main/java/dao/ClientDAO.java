package dao;

import model.ClientEntity;

/**
 * Created by oleg on 25.11.2015.
 */
public interface ClientDAO extends CommonDAO<ClientEntity, Integer> {
    ClientEntity findByName(String name, String family);
}
