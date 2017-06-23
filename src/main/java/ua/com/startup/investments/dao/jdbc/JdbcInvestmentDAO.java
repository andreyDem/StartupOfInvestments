package ua.com.startup.investments.dao.jdbc;

import ua.com.startup.investments.dao.InvestmentDAO;
import ua.com.startup.investments.entities.Investment;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

//import org.slf4j.Logger;

/**
 * The class implements a set of methods for working
 * with database, with Investment entity.
 *
 * @author Girya Aleksey
 */
public class JdbcInvestmentDAO implements InvestmentDAO {

    //  private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JdbcUsersDAO.class);

    /**
     * A pattern of an SQL command (without particular values)
     * for saving a investment in a database
     */
    private static final String CREATE = "INSERT INTO INVESTMENTS (SUM) VALUE (?)";

    /**
     * A pattern of an SQL command (without particular value)
     * for finding a investment in a database by id od investments
     */
    private static final String FIND_BY_ID = "SELECT INVESTMENTS.ID ID_INVESTMENT, INVESTMENTS.SUM SUM_INVESTMENT, ID_PROJECT ID_PROJECT, \n" +
            "  PROJECTS.NAME PROJECT_NAME, FINAL_COST, ASSEMBLE_COST, PROJECTS.NAME, SURNAME\n" +
            "FROM investments INVESTMENTS\n" +
            "  JOIN investments_projects I_P ON INVESTMENTS.ID = I_P.ID_INVESTMENTS\n" +
            "  JOIN projects PROJECTS ON I_P.ID_PROJECT = PROJECTS.ID\n" +
            "  JOIN users USERS ON PROJECTS.ID_USER = USERS.ID;";

    /**
     * A pattern of an SQL command (without particular value)
     * for finding a investment in a database by user id
     */
    private static final String FIND_BY_USER_ID = "SELECT INVESTMENTS.ID ID_INVESTMENT, INVESTMENTS.SUM SUM_INVESTMENT, ID_PROJECT ID_PROJECT,\n" +
            "  PROJECTS.NAME PROJECT_NAME, FINAL_COST, ASSEMBLE_COST, PROJECTS.NAME, SURNAME\n" +
            "FROM investments INVESTMENTS\n" +
            "  JOIN investments_projects I_P ON INVESTMENTS.ID = I_P.ID_INVESTMENTS\n" +
            "  JOIN projects PROJECTS ON I_P.ID_PROJECT = PROJECTS.ID\n" +
            "  JOIN users USERS ON PROJECTS.ID_USER = USERS.ID\n" +
            "WHERE USERS.ID = ?";

    /**
     * A pattern of an SQL command (without particular value)
     * for finding a investment in a database by user name
     */
    private static final String FIND_BY_USER_NAME = "SELECT INVESTMENTS.ID ID_INVESTMENT, INVESTMENTS.SUM SUM_INVESTMENT, ID_PROJECT ID_PROJECT, PROJECTS.NAME PROJECT_NAME, FINAL_COST, ASSEMBLE_COST, OWNER, PROJECTS.NAME, SURNAME\n" +
            "FROM investments INVESTMENTS\n" +
            "  JOIN investments_projects I_P ON INVESTMENTS.ID = I_P.ID_INVESTMENTS\n" +
            "  JOIN projects PROJECTS ON I_P.ID_PROJECT = PROJECTS.ID\n" +
            "  JOIN investments_users I_U ON INVESTMENTS.ID = I_U.ID_INVESTMENTS\n" +
            "  JOIN users USERS ON I_U.ID_USER = USERS.ID\n" +
            "WHERE INVESTMENTS.SUM = ?";

    /**
     * A pattern of an SQL command (without particular value)
     * for finding a investment in a database by sum of investment
     */
    private static final String FIND_BY_PRICE = "SELECT INVESTMENTS.ID ID_INVESTMENT, INVESTMENTS.SUM SUM_INVESTMENT, ID_PROJECT ID_PROJECT,\n" +
            "  PROJECTS.NAME PROJECT_NAME, FINAL_COST, ASSEMBLE_COST, PROJECTS.NAME, SURNAME\n" +
            "FROM investments INVESTMENTS\n" +
            "  JOIN investments_projects I_P ON INVESTMENTS.ID = I_P.ID_INVESTMENTS\n" +
            "  JOIN projects PROJECTS ON I_P.ID_PROJECT = PROJECTS.ID\n" +
            "  JOIN users USERS ON PROJECTS.ID_USER = USERS.ID\n" +
            "WHERE INVESTMENTS.SUM = ?;";

    /**
     * A pattern of an SQL command (without particular value)
     * for finding a investment in a database by investment name
     */
    private static final String FIND_BY_PROJECT_NAME = " SELECT INVESTMENTS.ID ID_INVESTMENT, INVESTMENTS.SUM SUM_INVESTMENT, ID_PROJECT ID_PROJECT, PROJECTS.NAME PROJECT_NAME, FINAL_COST, ASSEMBLE_COST, OWNER, PROJECTS.NAME, SURNAME\n" +
            "FROM investments INVESTMENTS\n" +
            "  JOIN investments_projects I_P ON INVESTMENTS.ID = I_P.ID_INVESTMENTS\n" +
            "  JOIN projects PROJECTS ON I_P.ID_PROJECT = PROJECTS.ID\n" +
            "  JOIN investments_users I_U ON INVESTMENTS.ID = I_U.ID_INVESTMENTS\n" +
            "  JOIN users USERS ON I_U.ID_USER = USERS.ID\n" +
            "WHERE PROJECTS.NAME = ?";

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

    private DataSource dataSource;

    @Override
    public void createInvestments(Object investments) {

        try (Connection connection = dataSource.getConnection();) {
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Investment findById(Object id) {
        return null;
    }

    @Override
    public Investment findByUser(Object id) {
        return null;
    }

    @Override
    public Investment findByPrice(Object price) {
        return null;
    }

    @Override
    public Investment findByProject(Object id) {
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
