package ua.com.startup.investments.connection;

import java.sql.SQLException;

/**
 * Interface with one method, that returns instance of ConnectionDB class. Classes, that return ConnectionDB's instances
 * should implement that interface
 *
 * @author Aleksey Girya
 */
public interface ConnectionDB {

    /**
     * Method for getting connection. Needs to be implemented.
     *
     * @return an instance of ConnectionDB class, the connection to database
     * @throws SQLException in case of connection problems
     */
    ConnectionDB getConnection() throws SQLException;
}
