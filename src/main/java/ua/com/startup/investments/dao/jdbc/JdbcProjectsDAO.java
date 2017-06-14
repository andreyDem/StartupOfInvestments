package ua.com.startup.investments.dao.jdbc;

import ua.com.startup.investments.dao.ProjectDAO;
import ua.com.startup.investments.entities.Project;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Aleksey on 13.06.2017.
 */
public class JdbcProjectsDAO implements ProjectDAO{

    @Override
    public void createProject(Object project) {

    }

    @Override
    public Project findById(Object id) {
        return null;
    }

    @Override
    public Project findByName(Object name) {
        return null;
    }

    @Override
    public void update(Object id) {

    }

    @Override
    public void delete(Object id) {

    }

    @Override
    public List findAll() {
        return null;
    }
}
