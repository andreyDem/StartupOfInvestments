package ua.com.startup.investments.dao.jdbc;

import com.sun.org.apache.regexp.internal.RE;
import org.slf4j.Logger;
import ua.com.startup.investments.dao.InvestmentDAO;
import ua.com.startup.investments.entities.Investment;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//import org.slf4j.Logger;

/**
 * The class implements a set of methods for working
 * with database, with Investment entity.
 *
 * @author Girya Aleksey
 */
public class JdbcInvestmentDAO implements InvestmentDAO<Investment, Integer> {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JdbcInvestmentDAO.class);

    /**
     * A pattern of an SQL command (without particular values)
     * for saving a investment in a database
     */
    private static final String CREATE = "INSERT INTO INVESTMENTS (SUM) VALUE (?)";

    /**
     * A pattern of an SQL command (without particular value)
     * for finding a investment in a database by id od investments
     */
    private static final String FIND_BY_ID = "SELECT INVESTMENTS.ID, SUM, ID_PROJECT , PROJECTS.NAME, FINAL_COST, ASSEMBLE_COST, USERS.NAME, SURNAME FROM investments INVESTMENTS\n" +
            "  JOIN investments_projects I_P ON INVESTMENTS.ID = I_P.ID_INVESTMENTS JOIN projects PROJECTS ON I_P.ID_PROJECT = PROJECTS.ID JOIN users USERS ON PROJECTS.ID_USER = USERS.ID WHERE INVESTMENTS.ID = ?;";

    /**
     * A pattern of an SQL command (without particular value)
     * for finding a investment in a database by user id
     */
    private static final String FIND_BY_USER_ID = "SELECT INVESTMENTS.ID, INVESTMENTS.SUM, ID_PROJECT, PROJECTS.NAME, FINAL_COST, ASSEMBLE_COST, SURNAME\n" +
            "FROM investments INVESTMENTS JOIN investments_projects I_P ON INVESTMENTS.ID = I_P.ID_INVESTMENTS JOIN projects PROJECTS ON I_P.ID_PROJECT = PROJECTS.ID JOIN users USERS ON PROJECTS.ID_USER = USERS.ID WHERE USERS.ID = ?";

    /**
     * A pattern of an SQL command (without particular value)
     * for finding a investment in a database by user name
     */
    private static final String FIND_BY_USER_NAME = "SELECT INVESTMENTS.ID ID_INVESTMENT, INVESTMENTS.SUM SUM_INVESTMENT, ID_PROJECT ID_PROJECT, PROJECTS.NAME PROJECT_NAME, FINAL_COST, ASSEMBLE_COST, OWNER, PROJECTS.NAME, SURNAME\n" +
            "FROM investments INVESTMENTS JOIN investments_projects I_P ON INVESTMENTS.ID = I_P.ID_INVESTMENTS JOIN projects PROJECTS ON I_P.ID_PROJECT = PROJECTS.ID JOIN investments_users I_U ON INVESTMENTS.ID = I_U.ID_INVESTMENTS\n" +
            "  JOIN users USERS ON I_U.ID_USER = USERS.ID\n" +
            "WHERE INVESTMENTS.SUM = ?";

    /**
     * A pattern of an SQL command (without particular value)
     * for finding a investment in a database by sum of investment
     */
    private static final String FIND_BY_PRICE = "SELECT INVESTMENTS.ID ID_INVESTMENT, INVESTMENTS.SUM SUM_INVESTMENT, ID_PROJECT ID_PROJECT, PROJECTS.NAME PROJECT_NAME, FINAL_COST, ASSEMBLE_COST, PROJECTS.NAME, SURNAME\n" +
            "FROM investments INVESTMENTS JOIN investments_projects I_P ON INVESTMENTS.ID = I_P.ID_INVESTMENTS JOIN projects PROJECTS ON I_P.ID_PROJECT = PROJECTS.ID JOIN users USERS ON PROJECTS.ID_USER = USERS.ID WHERE INVESTMENTS.SUM = ?;";

    /**
     * A pattern of an SQL command (without particular value)
     * for finding a investment in a database by investment name
     */
    private static final String FIND_BY_PROJECT_ID = " SELECT INVESTMENTS.ID ID_INVESTMENT, INVESTMENTS.SUM SUM_INVESTMENT, ID_PROJECT ID_PROJECT, PROJECTS.NAME PROJECT_NAME, FINAL_COST, ASSEMBLE_COST, OWNER, PROJECTS.NAME, SURNAME\n" +
            "FROM investments INVESTMENTS JOIN investments_projects I_P ON INVESTMENTS.ID = I_P.ID_INVESTMENTS JOIN projects PROJECTS ON I_P.ID_PROJECT = PROJECTS.ID JOIN investments_users I_U ON INVESTMENTS.ID = I_U.ID_INVESTMENTS\n" +
            "  JOIN users USERS ON I_U.ID_USER = USERS.ID WHERE PROJECTS.ID = ?";

    /**
     * A pattern of an SQL command (without particular values)
     * for update a investment in a database
     */
    private static final String UPDATE = "UPDATE investments SET  SUM = ? WHERE ID = ?;";

    /**
     * A pattern of an SQL command (without particular value)
     * for removing an investment from a database by id
     */
    private static final String DELETE = "DELETE FROM investments WHERE ID = ?;";

    /**
     * An SQL command for getting all investments from a database
     */
    private static final String FIND_ALL = "SELECT * FROM investments;";

    /**
     * A pattern of an SQL command  for finding a id from the last
     * inserted investment in a database
     */
    private final static String GET_LAST_INSERTED = "SELECT LAST_INSERT_ID()";

    /**
     * Connection to database
     */
    private DataSource dataSource;

    /**
     * Method saves a new investment in database
     *
     * @param investments for saving in a database
     */
    @Override
    public void createInvestments(Investment investments) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
             Statement statement = connection.createStatement()) {
            LOGGER.info("Add new investment in data base ");
            preparedStatement.setInt(1, Integer.parseInt("SUM"));
        } catch (SQLException e) {
            LOGGER.error("Cannot create new investment ");
        }
    }

    /**
     * Method which find current project by id
     *
     * @param id_investment the id of an investment
     * @return an investment by entered id
     * or new investment with empty parameters if investment with this id does not exist
     */
    @Override
    public Investment findById(Integer id_investment) {
        Investment investment = new Investment();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)) {
            LOGGER.info("Find investment by id " + id_investment);
            preparedStatement.setInt(1, Integer.parseInt("ID"));
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                investment = new Investment(
                        resultSet.getInt("ID"),
                        resultSet.getInt("SUM")
                );
            }
        } catch (SQLException e) {
            LOGGER.error("Cannot find investment by id " + id_investment);
        }
        return investment;
    }

    /**
     * Method which find current project by id
     *
     * @param id_user the id of an investment
     * @return an investment by entered id_user
     * or new investment with empty parameters if investment with this id does not exist
     */
    @Override
    public Investment findByUser(Integer id_user) {
        Investment investment = new Investment();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_USER_ID)) {
            LOGGER.info("Find investment by user id " + id_user);
            preparedStatement.setInt(1, id_user);
            ResultSet resultSet = preparedStatement.executeQuery();
            investment = new Investment(
                    resultSet.getInt("ID"),
                    resultSet.getInt("SUM")
            );
        } catch (SQLException e) {
            LOGGER.error("Cannot find investments by user id " + id_user);
        }
        return investment;
    }

    /**
     * Method which find current project by id
     *
     * @param price of the investment
     * @return an investment by entered price
     * or new investment with empty parameters if investment with this id does not exist
     */
    @Override
    public Investment findByPrice(Integer price) {
        Investment investment = new Investment();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_PRICE)) {
            preparedStatement.setInt(1, price);
            ResultSet resultSet = preparedStatement.executeQuery();
            investment = new Investment(
                    resultSet.getInt("ID"),
                    resultSet.getInt("SUM")
            );
        } catch (SQLException e) {
            LOGGER.error("Cannot find investment by price " + price);
        }
        return investment;
    }

    /**
     * Method which find current project by id
     *
     * @param id the id of a project
     * @return an investment by entered id project
     * or new investment with empty parameters if investment with this id does not exist
     */
    @Override
    public Investment findByProject(Integer id) {
        Investment investment = new Investment();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_PROJECT_ID)) {
            LOGGER.info("Find investment by project id " + id);
            ResultSet resultSet = preparedStatement.executeQuery();
            investment = new Investment(
                    resultSet.getInt("ID"),
                    resultSet.getInt("SUM")
            );
        } catch (SQLException e) {
            LOGGER.error("Cannot find investments by project id " + id);
        }
        return investment;
    }

    /**
     * The method updates an investment in a database
     * (finds project in a database by id and overwrites other fields)
     *
     * @param id investment with new parameters
     */
    @Override
    public void update(Investment id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            LOGGER.info("Update investment " + id);
            preparedStatement.setInt(1, Integer.parseInt("SUM"));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Cannot update investment " + id);
        }
    }

    /**
     * The method removes an investment from a database
     *
     * @param id is an investment which must be removed
     */
    @Override
    public void delete(Integer id) {
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            LOGGER.info("Delete investment from data base " + id);
            preparedStatement.setInt(1, Integer.parseInt("ID"));
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Cannot delete investment from data base " + id);
        }

    }

    /**
     * Method returns all investments from the database
     *
     * @return list of all investments from the database
     */
    @Override
    public List findAll() {
        List<Investment> investments = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            LOGGER.info("Find all users in data base ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                investments.add(new Investment(
                        resultSet.getInt("ID"),
                        resultSet.getInt("SUM")
                ));
            }

        } catch (SQLException e) {
            LOGGER.error("Cannot find list of all investments");
        }
        return null;
    }
}
