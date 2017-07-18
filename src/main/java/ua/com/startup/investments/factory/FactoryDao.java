package ua.com.startup.investments.factory;

import ua.com.startup.investments.connection.ConnectionMySql;
import ua.com.startup.investments.dao.InvestmentDAO;
import ua.com.startup.investments.dao.ProjectDAO;
import ua.com.startup.investments.dao.UserDAO;
import ua.com.startup.investments.dao.jdbc.JdbcInvestmentDAO;
import ua.com.startup.investments.dao.jdbc.JdbcProjectsDAO;
import ua.com.startup.investments.dao.jdbc.JdbcUsersDAO;

import java.sql.SQLException;

/**
 * The class implements the Factory pattern.
 * It creates and supplies of JDBC implementations of DAOs
 *
 * @author Demchuk Andrii
 */
public final class FactoryDao {

    /**
     * An instance of InvestmentDAO
     */
    private static InvestmentDAO investmentDAO;

    /**
     * An instance of ProjectDAO
     */
    private static ProjectDAO projectDAO;

    /**
     * An instance of UserDAO
     */
    private static UserDAO userDAO;

    /**
     * Private constructor
     */
    private FactoryDao() {
    }

    /**
     * The method returns an instance of InvestmentDAO,
     * and invoke method createInvestmentDAO() if the instance of InvestmentDAO
     * is not exist
     *
     * @return an instance of InvestmentDAO
     * @throws SQLException in case of connection problems
     */
    public static InvestmentDAO getInvestmentDAO() throws SQLException {
        if (investmentDAO == null) {
            investmentDAO = createInvestmentDAO();
        }
        return investmentDAO;
    }

    /**
     * The method creates and returns an instance of InvestmentDAO
     *
     * @return an instance of InvestmentDAO
     * @throws SQLException in case of connection problems
     */
    private static InvestmentDAO createInvestmentDAO() throws SQLException {
        return new JdbcInvestmentDAO(ConnectionMySql.connectionMySql());
    }

    /**
     * The method returns an instance of ProjectDAO,
     * and invoke method createProjectDAO() if the instance of
     * ProjectDAO is not exist
     *
     * @return an instance of ProjectDAO
     * @throws SQLException in case of connection problems
     */
    public static ProjectDAO getProjectDAO() throws SQLException {
        if (projectDAO == null) {
            projectDAO = createProjectDAO();
        }
        return projectDAO;
    }

    /**
     * The method creates and returns an instance of ProjectDAO
     *
     * @return an instance of ProjectDAO
     * @throws SQLException in case of connection problems
     */
    private static ProjectDAO createProjectDAO() throws SQLException {
        return new JdbcProjectsDAO(ConnectionMySql.connectionMySql().getConnection());
    }

    /**
     * The method returns an instance of UserDAO,
     * and invoke method createUserDAO()
     * if the instance of UserDAO is not exist
     *
     * @return an instance of UserDAO
     * @throws SQLException in case of connection problems
     */
    public static UserDAO getUserDAO() throws SQLException {
        if (userDAO == null) {
            userDAO = createUserDAO();
        }
        return userDAO;
    }

    /**
     * The method creates and returns an instance of UserDAO
     *
     * @return an instance of UserDAO
     * @throws SQLException in case of connection problems
     */
    private static UserDAO createUserDAO() throws SQLException {
        return new JdbcUsersDAO(ConnectionMySql.connectionMySql());
    }
}
