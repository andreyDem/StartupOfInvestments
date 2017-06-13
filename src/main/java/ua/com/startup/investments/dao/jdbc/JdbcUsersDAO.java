package ua.com.startup.investments.dao.jdbc;

import ua.com.startup.investments.dao.UserDAO;
import ua.com.startup.investments.entities.User;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Aleksey on 13.06.2017.
 */
public class JdbcUsersDAO implements UserDAO {
    @Override
    public void createUser(Serializable user) {

    }

    @Override
    public User findById(Serializable id) {
        return null;
    }

    @Override
    public User findByName(Serializable name) {
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
