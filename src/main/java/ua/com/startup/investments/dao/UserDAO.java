package ua.com.startup.investments.dao;

import ua.com.startup.investments.entities.User;

import java.io.Serializable;
import java.util.List;

/**
 * The interface for working with data base and entity
 * The interface will be implemented by DAO classes that will work with User entity
 *
 * @author Girya Aleksey
 */


public interface UserDAO<T, H, ID> {
    /**
     * Method for creating a new entity in a database
     *
     * @param user an entity for saving in a database
     */
    void save(T user);

    /**
     * Method for finding entity in a database by id
     *
     * @param id the id of an entity
     * @return founded entity of User
     */
    User findById(ID id);

    /**
     * Method for finding entity in a database by id
     *
     * @param name the id of an entity
     * @return founded entity of User
     */
    User findByName(H name);

    /**
     * Method for updating entity in a database
     *
     * @param id an entity with new parameters for updating
     */
    void update(ID id);

    /**
     * Method for deleting entity in a database
     *
     * @param id an entity for delete from DB
     */
    void delete(ID id);
    
    /**
     * Method for getting all entities of a certain type
     *
     * @return list of entities
     */
    List<T> findAll();
}
