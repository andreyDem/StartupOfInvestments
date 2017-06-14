package ua.com.startup.investments.dao;

import ua.com.startup.investments.entities.Investment;
import ua.com.startup.investments.entities.Project;

import java.io.Serializable;
import java.util.List;

public interface ProjectDAO<T> {

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
    Project findById(T id);

    /**
     * Method for finding entity in a database by id
     *
     * @param name the id of an entity
     * @return founded entity of Project
     */
    Project findByName(T name);

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
