package ua.com.startup.investments.dao.jdbc;

import org.slf4j.Logger;
import ua.com.startup.investments.connection.ConnectionDB;
import ua.com.startup.investments.dao.ProjectDAO;
import ua.com.startup.investments.entities.Project;

import javax.sql.DataSource;
import java.awt.image.RescaleOp;
import java.io.Serializable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * The class implements a set of methods for working
 * with database, with Project entity.
 *
 * @author Girya Aleksey
 */
public class JdbcProjectsDAO implements ProjectDAO<Project, String, Integer> {

    /**
     * Logger slf4j. All logs saves in target.jdbc
     */
    private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JdbcProjectsDAO.class);

    /**
     * A pattern of an SQL command (without particular values)
     * for saving a project in the database
     */
    private static final String CREATE = "INSERT INTO projects  (NAME, SOLUTION, FINAL_COST, ASSEMBLE_COST, ID_USER) VALUES (?, ?, ?, ?, ?);";

    /**
     * A pattern of an SQL command (without particular value)
     * for finding a investment in a database by project id
     */
    private static final String FIND_BY_ID = "SELECT NAME, SOLUTION, FINAL_COST, ASSEMBLE_COST, USERS.NAME FROM projects PROJECTS JOIN users USERS ON PROJECTS.ID_USER = USERS.ID WHERE PROJECTS.ID = ?;";
    /**
     * A pattern of an SQL command (without particular value)
     * for finding a investment in a database by project name
     */
    private static final String FIND_BY_NAME = "SELECT USERS.NAME, SOLUTION, FINAL_COST, ASSEMBLE_COST, USERS.NAME FROM projects PROJECTS JOIN users USERS ON PROJECTS.ID_USER = USERS.ID WHERE PROJECTS.NAME = ?;";

    /**
     * A pattern of an SQL command (without particular values)
     * for update a project in a database
     */
    private static final String UPDATE = "UPDATE projects SET NAME = ?, SOLUTION = ?, FINAL_COST = ?, ASSEMBLE_COST = ?, ID_USER = ? WHERE ID = ?;";

    /**
     * A pattern of an SQL command (without particular value)
     * for removing an project from a database by id
     */
    private static final String DELETE = "DELETE FROM projects WHERE ID = ?;";

    /**
     * An SQL command for getting all projects from a database
     */
    private static final String FIND_ALL = "SELECT * FROM projects";

    /**
     * A pattern of an SQL command  for finding a id from the last
     * inserted projects in a database
     */
    private final static String GET_LAST_INSERTED = "SELECT LAST_INSERT_ID()";

    private ConnectionDB connectionDB;

    /**
     * Method saves a new project in database
     *
     * @param project for saving in a database
     */
    @Override
    public void createProject(Project project) {
        try (Connection connection = (Connection) connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(CREATE);
             Statement statement = connection.createStatement()) {
            LOGGER.info("Save project in data base");
            preparedStatement.setString(1, "NAME");
            preparedStatement.setString(2, "SOLUTION");
            preparedStatement.setInt(3, Integer.parseInt("FINAL_COST"));
            preparedStatement.setInt(4, Integer.parseInt("ASSEMBLE_COST"));
            preparedStatement.setInt(5, Integer.parseInt("ID_USER"));
            ResultSet resultSet = statement.executeQuery(GET_LAST_INSERTED);
            resultSet.next();
        } catch (SQLException e) {
            LOGGER.error("Cannot save project in data base");
        }
    }

    /**
     * Method which find current project by id
     *
     * @param id the id of a project
     * @return a project by entered id
     * or new project with empty parameters if project with this id does not exist
     */
    @Override
    public Project findById(Integer id) {
        Project foundedProject = new Project();
        try (Connection connection = (Connection) connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID)
        ) {
            LOGGER.info("Finding project by id " + id);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                foundedProject = new Project(
                        resultSet.getInt("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getString("Solution"),
                        resultSet.getInt("FINAL_COST"),
                        resultSet.getInt("ASSEMBLE_COST"),
                        resultSet.getInt("ID_USER")
                );
            }
        } catch (SQLException e) {
            LOGGER.error("Cannot find project in data base by id " + id);
        }
        return foundedProject;
    }

    /**
     * Method which find current project by name
     *
     * @param name the name of a user
     * @return a user with entered id
     * or new user with empty parameters if project with this id does not exist
     */
    @Override
    public Project findByName(String name) {
        Project project = new Project();
        try (Connection connection = (Connection) connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_NAME)
        ) {
            LOGGER.info("Finding project by name " + name);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                project = new Project(
                        resultSet.getInt("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getString("SOLUTION"),
                        resultSet.getInt("FINAL_COST"),
                        resultSet.getInt("ASSEMBLE_COST"),
                        resultSet.getInt("ID_USER"));
            }

        } catch (SQLException e) {
            LOGGER.error("Cannot find project by name " + name);
        }
        return project;
    }

    /**
     * Method updates project in the database
     *
     * @param project a project with new parameters
     */
    @Override
    public void update(Project project) {
        try (Connection connection = (Connection) connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            LOGGER.info("Update project " + project.getId());
            preparedStatement.setString(1, project.getName());
            preparedStatement.setString(2, project.getSolution());
            preparedStatement.setInt(3, project.getFinalCost());
            preparedStatement.setInt(4, project.getAssembleCost());
            preparedStatement.setInt(5, project.getIdUser());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Cannot update project " + project.getId());
        }
    }

    /**
     * Method removes a project from database
     *
     * @param id project which must be removed
     */
    @Override
    public void delete(Integer id) {
        try (Connection connection = (Connection) connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            LOGGER.info("Delete project " + id);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error("Cannot delete project " + id);
        }
    }

    /**
     * Method returns all projects from the database
     *
     * @return list of all projects from the database
     */
    @Override
    public List findAll() {
        List<Project> projects = new ArrayList<>();
        try (Connection connection = (Connection) connectionDB.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(FIND_ALL)) {
            LOGGER.info("Finding all users ");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                projects.add(new Project(
                        resultSet.getInt("ID"),
                        resultSet.getString("NAME"),
                        resultSet.getString("SOLUTION"),
                        resultSet.getInt("FINAL_COST"),
                        resultSet.getInt("ASSEMBLE_COST"),
                        resultSet.getInt("ID_USER")
                ));
            }
        } catch (SQLException e) {
            LOGGER.error("Cannot find list of all projects ");
        }
        return projects;
    }
}
