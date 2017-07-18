package ua.com.startup.investments.dao.jdbc;

import org.slf4j.Logger;
import ua.com.startup.investments.dao.UserDAO;
import ua.com.startup.investments.entities.Roles;
import ua.com.startup.investments.entities.User;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The class implements a set of methods for working
 * with database, with Users entity.
 *
 * @author Girya Aleksey
 */

public class JdbcUsersDAO implements UserDAO<User, String, Integer> {
    /**
     * Logger slf4j. All logs saves in target.jdbc
     */
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JdbcUsersDAO.class);

    /**
     * A pattern of an SQL command (without particular values)
     * for saving an user in a database
     */
    private static final String CREATE_USER = "INSERT INTO USERS (NAME, SURNAME, ADDRESS, PHONE, ROLE) VALUES (?, ?, ?, ?, ?)";

    /**
     * A pattern of an SQL command (without particular value)
     * for finding an user in a database by id
     */
    private static final String FIND_BY_ID = "SELECT * FROM  USERS WHERE USERS.ID = ?;";

    /**
     * A pattern of an SQL command (without particular value)
     * for finding an user in a database by name
     */
    private static final String FIND_BY_NAME = "SELECT NAME, SURNAME, ADDRESS, PHONE, ROLE FROM  USERS WHERE users.NAME = ?;";

    /**
     * A pattern of an SQL command (without particular value)
     * for update an user in a database by id
     */
    private static final String UPDATE = "UPDATE users SET NAME = ?, SURNAME = ?, ADDRESS = ?, PHONE = ?, ROLE = ? WHERE ID = ?;";

    /**
     * A pattern of an SQL command (without particular value)
     * for delete an user in a database by id
     */
    private static final String DELETE = "DELETE FROM users WHERE ID = ?;";

    /**
     * A pattern of an SQL command (without particular value)
     * for finding all orders in a database by id
     */
    private static final String FIND_ALL = "SELECT * FROM users";

    /**
     * Connection to database
     */
    private DataSource dataSource;

    /**
     * Method saves a new user in database
     *
     * @param user for saving in a database
     */
    @Override
    public void save(User user) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE_USER);
             Statement statement = connection.createStatement()) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getSurname());
            preparedStatement.setString(3, user.getAddress());
            preparedStatement.setInt(4, user.getPhone());
            preparedStatement.setObject(5, Roles.values());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method which find current user by id
     *
     * @param id the id of a user
     * @return a user with entered id
     * or new user with empty parameters if user with this id does not exist
     */
    @Override
    public User findById(Integer id) {
        User foundedUser = new User();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)
        ) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                foundedUser = new User(
                        resultSet.getInt("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getString("SURNAME"),
                        resultSet.getString("ADDRES"),
                        resultSet.getInt("PHONE"),
                        (Roles) resultSet.getObject("ROLE")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return foundedUser;
    }

    /**
     * Method which find current user by name
     *
     * @param name the name of a user
     * @return a user with entered id
     * or new user with empty parameters if user with this id does not exist
     */
    @Override
    public User findByName(String name) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME);
        ) {
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                new User(
                        resultSet.getInt("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getString("SURNAME"),
                        resultSet.getString("ADDRESS"),
                        resultSet.getInt("PHONE"),
                        (Roles) resultSet.getObject("ROLE")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Method updates user in the database
     *
     * @param id a user with new parameters
     */
    @Override
    public void update(Integer id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)
        ) {
            preparedStatement.setString(1, "NAME");
            preparedStatement.setString(2, "SURNAME");
            preparedStatement.setString(3, "ADDRESS");
            preparedStatement.setInt(4, Integer.parseInt("PHONE"));
            preparedStatement.setObject(5, "ROLE");
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method removes an user from database
     *
     * @param id user which must be removed
     */
    @Override
    public void delete(Integer id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)
        ) {
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method returns all users from the database
     *
     * @return list of all users from the database
     */
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                users.add(new User(
                        resultSet.getInt("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getString("SURNAME"),
                        resultSet.getString("ADDRESS"),
                        resultSet.getInt("PHONE"),
                        (Roles) resultSet.getObject("ROLE"))
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
}
