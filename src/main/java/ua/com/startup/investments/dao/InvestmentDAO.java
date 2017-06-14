package ua.com.startup.investments.dao;

import ua.com.startup.investments.entities.Investment;

import java.io.Serializable;
import java.util.List;

public interface InvestmentDAO<T> {

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
    Investment findById(T id);

    /**
     * Method for finding entity in a database by id
     *
     * @param id the id of an entity
     * @return founded entity of Investment
     */
    Investment findByUser(T id);

    /**
     * Method for finding entity in a database by id
     *
     * @param price of the entity
     * @return founded by price entity of Investment
     */
    Investment findByPrice(T price);

    /**
     * Method for finding entity in a database by id
     *
     * @param id of the entity Project
     * @return founded by id project entity of Investment
     */
    Investment findByProject(T id);

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
    void delete(T id);

    /**
     * Method for getting all entities of a certain type
     *
     * @return list of entities
     */
    List<T> findAll();
}
