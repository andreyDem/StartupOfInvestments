package ua.com.startup.investments.dao.jdbc;

import ua.com.startup.investments.dao.UserDAO;
import ua.com.startup.investments.entities.User;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aleksey on 13.06.2017.
 */
public class JdbcUsersDAO implements UserDAO {

    private DataSource dataSource;

    private static final String CREATE_USER = "INSERT INTO users (NAME, SURNAME, ADDRESS, PHONE) VALUES (?, ?, ?, ?)";

    private static final String FIND_BY_ID = "SELECT * FROM users WHERE id = ?";

    private static final String FIND_BY_NAME = "SELECT * FROM users WHERE name = ?";

    private static final String UPDATE = "UPDATE users SET name = ? WHERE id = ?";

    private final static String DELETE = "DELETE FROM users WHERE id = ?";

    private final static String FIND_ALL = "SELECT * FROM users";

    @Override
    public void save(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setInt(4, user.getPhone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findById(Long id) {
        User foundedUser = new User(id, "", "" , null);
        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)){
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                foundedUser = new User(
                        resultSet.getLong("id"),
                        resultSet.getNString("name"),
                        resultSet.getNString("surname"),
                        resultSet.getInt("phone")
                );
            }
            return foundedUser;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findByName(String nameUser) {
        User user = new User((long)0, nameUser);
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME)) {
            preparedStatement.setString(1, nameUser);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                user = new User(
                        resultSet.getLong("id"),
                        resultSet.getString("name")
                );
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setLong(2, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setLong(1, user.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<User> findAll() {
        List<User> allCompanies = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                allCompanies.add(
                        new User(
                                resultSet.getLong("id"),
                                resultSet.getString("name")
                        )
                );
            }
            return allCompanies;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
