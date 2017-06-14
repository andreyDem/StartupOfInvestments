package ua.com.startup.investments.dao.jdbc;

import ua.com.startup.investments.dao.InvestmentDAO;
import ua.com.startup.investments.entities.Investment;

import java.util.List;

//import org.slf4j.Logger;

/**
 * The class implements a set of methods for working
 * with database, with Company entity.
 *
 * @author Girya Aleksey
 */
public class JdbcInvestmentDAO implements InvestmentDAO {

  //  private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JdbcUsersDAO.class);

    /**
     * A pattern of an SQL command (without particular values)
     * for saving a investment in a database
     */
    private static final String CREATE = "INSERT INTO INVESTMENTS (PRICE) VALUE (?)";

    /**
     * A pattern of an SQL command (without particular value)
     * for finding a investment in a database by id
     */
    private static final String FIND_BY_ID = "SELECT INVESTMENTS.ID ID_INVESTMENT, INVESTMENTS.SUM SUM_INVESTMENT, ID_PROJECT ID_PROJECT, PROJECTS.NAME PROJECT_NAME, FINAL_COST, ASSEMBLE_COST, OWNER, PROJECTS.NAME, SURNAME\n" +
            "FROM investments INVESTMENTS\n" +
            "  JOIN investments_projects I_P ON INVESTMENTS.ID = I_P.ID_INVESTMENTS\n" +
            "  JOIN projects PROJECTS ON I_P.ID_PROJECT = PROJECTS.ID\n" +
            "  JOIN investments_users I_U ON INVESTMENTS.ID = I_U.ID_INVESTMENTS\n" +
            "  JOIN users USERS ON I_U.ID_USER = USERS.ID;";

    /**
     * A pattern of an SQL command (without particular value)
     * for finding a investment in a database by user id
     */
    private static final String FIND_BY_USER = "SELECT INVESTMENTS.ID ID_INVESTMENT, INVESTMENTS.SUM SUM_INVESTMENT, ID_PROJECT ID_PROJECT, PROJECTS.NAME PROJECT_NAME, FINAL_COST, ASSEMBLE_COST, OWNER, PROJECTS.NAME, SURNAME\n" +
            "FROM investments INVESTMENTS\n" +
            "  JOIN investments_projects I_P ON INVESTMENTS.ID = I_P.ID_INVESTMENTS\n" +
            "  JOIN projects PROJECTS ON I_P.ID_PROJECT = PROJECTS.ID\n" +
            "  JOIN investments_users I_U ON INVESTMENTS.ID = I_U.ID_INVESTMENTS\n" +
            "  JOIN users USERS ON I_U.ID_USER = USERS.ID\n" +
            "WHERE USERS.ID = ?";

    /**
     * A pattern of an SQL command (without particular value)
     * for finding a investment in a database by sum of investment
     */
    private static final String FIND_BY_PRICE = "SELECT INVESTMENTS.ID ID_INVESTMENT, INVESTMENTS.SUM SUM_INVESTMENT, ID_PROJECT ID_PROJECT, PROJECTS.NAME PROJECT_NAME, FINAL_COST, ASSEMBLE_COST, OWNER, PROJECTS.NAME, SURNAME\n" +
            "FROM investments INVESTMENTS\n" +
            "  JOIN investments_projects I_P ON INVESTMENTS.ID = I_P.ID_INVESTMENTS\n" +
            "  JOIN projects PROJECTS ON I_P.ID_PROJECT = PROJECTS.ID\n" +
            "  JOIN investments_users I_U ON INVESTMENTS.ID = I_U.ID_INVESTMENTS\n" +
            "  JOIN users USERS ON I_U.ID_USER = USERS.ID\n" +
            "WHERE INVESTMENTS.SUM = ?";

    /**
     * A pattern of an SQL command (without particular value)
     * for finding a investment in a database by project name
     */
    private static final String FIND_BY_PROJECT = " SELECT INVESTMENTS.ID ID_INVESTMENT, INVESTMENTS.SUM SUM_INVESTMENT, ID_PROJECT ID_PROJECT, PROJECTS.NAME PROJECT_NAME, FINAL_COST, ASSEMBLE_COST, OWNER, PROJECTS.NAME, SURNAME\n" +
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
    private static final String UPDATE = "";

    /**
     * A pattern of an SQL command (without particular value)
     * for removing an investment from a database by id
     */
    private static final String DELETE = "";

    /**
     * An SQL command for getting all investment from a database
     */
    private static final String FIND_ALL = "";


    @Override
    public void createInvestments(Object investments) {

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
