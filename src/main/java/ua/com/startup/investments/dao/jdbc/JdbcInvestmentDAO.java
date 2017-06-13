package ua.com.startup.investments.dao.jdbc;

import org.jboss.logging.Logger;
import org.slf4j.Logger;
import ua.com.startup.investments.dao.InvestmentDAO;
import ua.com.startup.investments.entities.Investment;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Aleksey on 12.06.2017.
 */
public class JdbcInvestmentDAO implements InvestmentDAO {

    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JdbcUsersDAO.class);

    private static final String CREATE = "INSERT INTO INVESTMENTS (PRICE) VALUE (?)";


    private static final String FIND_BY_ID = "SELECT INVESTMENTS.ID ID_INVESTMENT, INVESTMENTS.SUM SUM_INVESTMENT, ID_PROJECT ID_PROJECT, PROJECTS.NAME PROJECT_NAME, FINAL_COST, ASSEMBLE_COST, OWNER, PROJECTS.NAME, SURNAME\n" +
            "FROM investments INVESTMENTS\n" +
            "  JOIN investments_projects I_P ON INVESTMENTS.ID = I_P.ID_INVESTMENTS\n" +
            "  JOIN projects PROJECTS ON I_P.ID_PROJECT = PROJECTS.ID\n" +
            "  JOIN investments_users I_U ON INVESTMENTS.ID = I_U.ID_INVESTMENTS\n" +
            "  JOIN users USERS ON I_U.ID_USER = USERS.ID;";

    private static final String FIND_BY_USER = "SELECT INVESTMENTS.ID ID_INVESTMENT, INVESTMENTS.SUM SUM_INVESTMENT, ID_PROJECT ID_PROJECT, PROJECTS.NAME PROJECT_NAME, FINAL_COST, ASSEMBLE_COST, OWNER, PROJECTS.NAME, SURNAME\n" +
            "FROM investments INVESTMENTS\n" +
            "  JOIN investments_projects I_P ON INVESTMENTS.ID = I_P.ID_INVESTMENTS\n" +
            "  JOIN projects PROJECTS ON I_P.ID_PROJECT = PROJECTS.ID\n" +
            "  JOIN investments_users I_U ON INVESTMENTS.ID = I_U.ID_INVESTMENTS\n" +
            "  JOIN users USERS ON I_U.ID_USER = USERS.ID\n" +
            "WHERE USERS.ID = ?";

    private static final String FIND_BY_PRICE = "SELECT INVESTMENTS.ID ID_INVESTMENT, INVESTMENTS.SUM SUM_INVESTMENT, ID_PROJECT ID_PROJECT, PROJECTS.NAME PROJECT_NAME, FINAL_COST, ASSEMBLE_COST, OWNER, PROJECTS.NAME, SURNAME\n" +
            "FROM investments INVESTMENTS\n" +
            "  JOIN investments_projects I_P ON INVESTMENTS.ID = I_P.ID_INVESTMENTS\n" +
            "  JOIN projects PROJECTS ON I_P.ID_PROJECT = PROJECTS.ID\n" +
            "  JOIN investments_users I_U ON INVESTMENTS.ID = I_U.ID_INVESTMENTS\n" +
            "  JOIN users USERS ON I_U.ID_USER = USERS.ID\n" +
            "WHERE INVESTMENTS.SUM = ?";

    private static final String FIND_BY_PROJECT = " SELECT INVESTMENTS.ID ID_INVESTMENT, INVESTMENTS.SUM SUM_INVESTMENT, ID_PROJECT ID_PROJECT, PROJECTS.NAME PROJECT_NAME, FINAL_COST, ASSEMBLE_COST, OWNER, PROJECTS.NAME, SURNAME\n" +
            "FROM investments INVESTMENTS\n" +
            "  JOIN investments_projects I_P ON INVESTMENTS.ID = I_P.ID_INVESTMENTS\n" +
            "  JOIN projects PROJECTS ON I_P.ID_PROJECT = PROJECTS.ID\n" +
            "  JOIN investments_users I_U ON INVESTMENTS.ID = I_U.ID_INVESTMENTS\n" +
            "  JOIN users USERS ON I_U.ID_USER = USERS.ID\n" +
            "WHERE PROJECTS.NAME = ?";


    private static final String UPDATE = "";


    private static final String DELETE = "";

    private static final String FIND_ALL = "";

    @Override
    public void createInvestments(Serializable investments) {

    }

    @Override
    public Investment findById(Serializable id) {
        return null;
    }

    @Override
    public Investment findByUser(Serializable id) {
        return null;
    }

    @Override
    public Investment findByPrice(Serializable price) {
        return null;
    }

    @Override
    public Investment findByProject(Serializable id) {
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
