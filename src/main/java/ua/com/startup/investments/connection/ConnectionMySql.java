package ua.com.startup.investments.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * The class implements  methods for creating connection to DB
 *
 * @author Aleksey Girya
 */

public class ConnectionMySql implements ConnectionDB {

    /**
     * Database's driver
     */
    private final static String DRIVER = "com.mysql.jdbc.Driver";

    /**
     * Database's URL
     */
    private final static String URL = "jdbc:mysql://localhost:3306/developers";

    /**
     * User's name in MySQL server
     */
    private final static String LOGIN = "root";

    /**
     * User's password in MySQL server
     */
    private final static String PASSWORD = "17198408";

    /**
     * reference of ConnectionMySql class
     */
    private static ConnectionMySql connectionMySql;

    /**
     * Private default constructor
     */
    private ConnectionMySql() {
    }

    /**
     * This method create instance of this class or return instance if it already exist
     *
     * @return instance of ConnectionMySql
     */
    public static ConnectionMySql connectionMySql() {
        if (connectionMySql == null) {
            connectionMySql = new ConnectionMySql();
            System.out.println("Instance of connectionMySQL created");
        }
        return connectionMySql;
    }

    /**
     * This method create connection to DB
     *
     * @return connection to DB
     * @throws SQLException in case of connection problems
     */
    @Override
    public ConnectionDB getConnection() throws SQLException {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to load class");
            e.printStackTrace();
        }
        return (ConnectionDB) DriverManager.getConnection(URL, LOGIN, PASSWORD);
    }
}
