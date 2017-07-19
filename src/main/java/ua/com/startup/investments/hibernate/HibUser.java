package ua.com.startup.investments.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.com.startup.investments.dao.UserDAO;
import ua.com.startup.investments.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * The class implements a set of methods for working with
 * database including Hibernate framework, with User entity
 *
 * @author Demchuk Andrii
 */

public class HibUser implements UserDAO<User, String, Integer> {

    /**
     * An instance of SessionFactory
     */
    private SessionFactory sessionFactory;

    /**
     * Constructor
     *
     * @param sessionFactory an instance of SessionFactory
     */
    public HibUser(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * The method create a new user in a database
     *
     * @param user a user, which must be create in a database
     * @return users id if a user was add to database successfully
     */
    @Override
    public void createUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.save(user);
        } catch (Exception e) {
            System.out.println("Exception occurred while trying to save user " + user);
            e.printStackTrace();
        }
    }
    /**
     * The method finds a user in database by id of the user
     *
     * @param id an id of a user
     * @return a user with entered id
     * or new user with empty parameters if user with this id does not exist in the database
     */
    @Override
    public User findById(Integer id) {
        User user = new User(id, "");
        try (Session session = sessionFactory.openSession()) {
            User userFromDB = session.get(User.class, id);
            if (userFromDB != null) {
                user = userFromDB;
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while trying to find user with id: " + id);
            e.printStackTrace();
        }
        return user;
    }
    /**
     * Method finds a user in a database by name of the user
     *
     * @param name is a name of a user
     * @return a user with entered name
     * or new user with empty parameters if user with this name does not exist in the database
     */
    @Override
    public User findByName(String name) {
        User user = new User(0, name);
        try (Session session = sessionFactory.openSession()) {
            List<User> users = session.createQuery("select c from User c where c.name like :name")
                    .setParameter("name", name).list();
            if (users.size() != 0) {
                user = users.get(0);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while trying to find user with name: " + name);
            e.printStackTrace();
        }
        return user;
    }

    /**
     * The method updates a user in a database
     * (finds user in a database by id and overwrites other fields)
     *
     * @param user is a user with new parameters
     */
    @Override
    public void update(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            User userFromDb = session.get(User.class, user.getId());
            if (userFromDb == null) {
                return;
            }
            userFromDb.setName(user.getName());
            userFromDb.setSurname(user.getSurname());
            userFromDb.setAddress(user.getAddress());
            userFromDb.setPhone(user.getPhone());
            userFromDb.setRole(user.getRole());
            session.update(userFromDb);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Exception occurred while trying to update user " + user.getName());
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    /**
     * The method removes a user from a database
     *
     * @param user is a user which must be removed
     */
    @Override
    public void delete(User user) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            User userFromDb = session.get(User.class, user.getId());
            if (userFromDb == null) {
                return;
            }
            session.delete(userFromDb);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Exception occurred while trying to delete user id = " + user.getName());
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }
    /**
     * The method returns all users from a database
     *
     * @return list of all users from a database
     */
    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        try (Session session = sessionFactory.openSession()) {
            users = session.createQuery("from User ").list();
        } catch (Exception e) {
            System.out.println("Exception occurred while trying to find all companies");
            e.printStackTrace();
        }
        return users;
    }
}
