package ua.com.startup.investments.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.com.startup.investments.dao.ProjectDAO;
import ua.com.startup.investments.entities.Project;

import java.util.ArrayList;
import java.util.List;

/**
 * The class implements a set of methods for working
 * with database including Hibernate framework, with Project entity
 *
 * @author Aleksey Girya
 */
public class HibProject implements ProjectDAO<Project, String, Integer> {

    /**
     * An instance of SessionFactory
     */
    private SessionFactory sessionFactory;

    /**
     * Constructor
     *
     * @param sessionFactory an instance of SessionFactory
     */
    public HibProject(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * The method creates a new project in a database
     *
     * @param project a project, which must be create in a database
     * @return the projects id if a project was add to database successfully
     */
    @Override
    public void createProject(Project project) {
        try (Session session = sessionFactory.openSession();) {
            session.save(project);
        } catch (Exception e) {
            System.out.println("Exception accurate while we try save project in DB");
            e.printStackTrace();
        }
    }

    /**
     * The method finds a project in database by id of the project
     *
     * @param projectId an id of a project
     * @return a project with entered id
     * or project with empty parameters if project with this id does not exist in the database
     */
    @Override
    public Project findById(Integer projectId) {
        Project project = new Project();
        try (Session session = sessionFactory.openSession()) {
            project = session.get(project.getClass(), projectId);
        } catch (Exception e) {
            System.out.println("Exception accurate while we try find user in DB by ID");
        }
        return project;
    }

    /**
     * The method finds a project in database by id of the project
     *
     * @param name a name of a project
     * @return a project with entered name
     * or project with empty parameters if project with this id does not exist in the database
     */
    @Override
    public Project findByName(String name) {
        Project project = new Project();
        try (Session session = sessionFactory.openSession()) {
            project = (Project) session.createQuery("from Project where name =:name");
        } catch (Exception e) {
            System.out.println("Exception accurate wile we try find project by name");
            e.printStackTrace();
        }
        return project;
    }

    /**
     * The method updates a project in a database
     * (finds project in a database by id and overwrites other fields)
     *
     * @param project is a project with new parameters
     */
    @Override
    public void update(Project project) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession();) {
            transaction = session.beginTransaction();
            Project projectFromDB = session.get(project.getClass(), project.getId());
            projectFromDB.setName(project.getName());
            projectFromDB.setSolution(project.getSolution());
            projectFromDB.setFinalCost(project.getFinalCost());
            projectFromDB.setAssembleCost(project.getAssembleCost());
            session.update(projectFromDB);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Exception occurred while trying update project in BD");
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    /**
     * The method removes a project from a database
     *
     * @param projectId is a project which must be removed from DB
     */
    @Override
    public void delete(Integer projectId) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            Project projectFromDB = session.get(Project.class, projectId);
            session.delete(projectFromDB);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Exception occurred while trying delete project from BD");
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    /**
     * The method returns all projects from a database
     *
     * @return list of all projects from a database
     */
    @Override
    public List<Project> findAll() {
        List<Project> projects = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            projects = session.createQuery("from Project").list();
        } catch (Exception e) {
            System.out.println("Exception occurred while trying to find all projects");
            e.printStackTrace();
        }
        return projects;
    }
}
