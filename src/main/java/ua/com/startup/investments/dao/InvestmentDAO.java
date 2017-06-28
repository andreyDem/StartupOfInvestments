package ua.com.startup.investments.dao;

import ua.com.startup.investments.entities.Investment;

import java.io.Serializable;
import java.util.List;

/**
 * The interface for working with data base and entity
 * The interface will be implemented by DAO classes that will work with Investment entity
 *
 * @author Girya Aleksey
 */

public interface InvestmentDAO<T, ID> {

    /**
     * Method for creating a new entity in a database
     *
     * @param investments an entity for saving in a database
     */
    void createInvestments(T investments);

    /**
     * Method for finding entity in a database by id
     *
     * @param id the id of an entity
     * @return founded entity of Investment
     */
    Investment findById(ID id);

    /**
     * Method for finding entity in a database by id
     *
     * @param id_user the id of an entity
     * @return founded entity of Investment
     */
    Investment findByUser(ID id_user);

    /**
     * Method for finding entity in a database by id
     *
     * @param price of the entity
     * @return founded by price entity of Investment
     */
    Investment findByPrice(ID price);

    /**
     * Method for finding entity in a database by id
     *
     * @param id of the entity Project
     * @return founded by id project entity of Investment
     */
    Investment findByProject(ID id);

    /**
     * Method for updating entity in a database
     *
     * @param id an entity with new parameters for updating
     */
    void update(T id);

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
