package ua.com.startup.investments.dao;

import ua.com.startup.investments.entities.Investment;
import ua.com.startup.investments.entities.Project;

import java.io.Serializable;
import java.util.List;

/**
 * The interface for working with data base and entity
 * The interface will be implemented by DAO classes that will work with Project entity
 *
 * @author Girya Aleksey
 */

public interface ProjectDAO<T, H, ID> {

    /**
     * Method for creating a new entity in a database
     *
     * @param project an entity for saving in a database
     */
    void createProject(T project);

    /**
     * Method for finding entity in a database by id
     *
     * @param id the id of an entity
     * @return founded entity of Project
     */
    Project findById(ID id);

    /**
     * Method for finding entity in a database by id
     *
     * @param name the id of an entity
     * @return founded entity of Project
     */
    Project findByName(H name);

    /**
     * Method for updating entity in a database
     *
     * @param project an entity with new parameters for updating
     */
    void update(T project);

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
