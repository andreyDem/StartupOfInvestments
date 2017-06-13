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
    public void createProject(Serializable project) {

    }

    @Override
    public Project findById(Serializable id) {
        return null;
    }

    @Override
    public Project findByName(Serializable name) {
        return null;
    }

    @Override
    public void update(Serializable id) {

    }

    @Override
    public void delete(Serializable id) {

    }

    @Override
    public List findAll() {
        return null;
    }
}
