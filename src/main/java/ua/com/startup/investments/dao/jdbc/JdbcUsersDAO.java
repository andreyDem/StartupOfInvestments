package ua.com.startup.investments.dao.jdbc;

import ua.com.startup.investments.dao.UserDAO;
import ua.com.startup.investments.entities.User;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 * Created by Aleksey on 13.06.2017.
 */
public class JdbcUsersDAO implements UserDAO<User, Long> {

    private DataSource dataSource;

    private static final String CREATE_USER = "INSERT INTO users (NAME, SURNAME, ADDRESS, PHONE) VALUES (?, ?, ?, ?)";

    @Override
    public void createUser(User user) {
       try(Connection connection = dataSource.getConnection();
       Statement statement = connection.createStatement();
       PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER)) {

       } catch (SQLException e) {
           e.printStackTrace();
       }
    }

    @Override
    public User findById(Long id) {
        return null;
    }

    @Override
    public User findByName(User name) {
        return null;
    }

    @Override
    public void update(Long id) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }
}
