package ua.com.startup.investments.dao.jdbc;

import ua.com.startup.investments.dao.ProjectDAO;
import ua.com.startup.investments.entities.Project;

import java.io.Serializable;
import java.util.List;

/**
 * The class implements a set of methods for working
 * with database, with Project entity.
 *
 * @author Girya Aleksey
 */
public class JdbcProjectsDAO implements ProjectDAO {

    //  private static final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(JdbcUsersDAO.class);

    /**
     * A pattern of an SQL command (without particular values)
     * for saving a project in the database
     */
    private static final String CREATE = "INSERT INTO projects  (NAME, SOLUTION, FINAL_COST, ASSEMBLE_COST, ID_USER) VALUES (?, ?, ?, ?, ?);";

    /**
     * A pattern of an SQL command (without particular value)
     * for finding a investment in a database by project id
     */
    private static final String FIND_BY_ID = "SELECT USERS.NAME, SOLUTION, FINAL_COST, ASSEMBLE_COST, USERS.NAME\n" +
            "FROM projects PROJECTS\n" +
            "  JOIN users USERS ON PROJECTS.ID_USER = USERS.ID\n" +
            "WHERE PROJECTS.ID = ?;";
    /**
     * A pattern of an SQL command (without particular value)
     * for finding a investment in a database by project name
     */
    private static final String FIND_BY_NAME = "SELECT USERS.NAME, SOLUTION, FINAL_COST, ASSEMBLE_COST, USERS.NAME\n" +
            "FROM projects PROJECTS\n" +
            "  JOIN users USERS ON PROJECTS.ID_USER = USERS.ID\n" +
            "WHERE PROJECTS.NAME = ?;";

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

    @Override
    public void createProject(Object project) {

    }

    @Override
    public Project findById(Object id) {
        return null;
    }

    @Override
    public Project findByName(Object name) {
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
