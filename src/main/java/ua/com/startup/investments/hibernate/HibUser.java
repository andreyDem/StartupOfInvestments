package ua.com.startup.investments.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.com.startup.investments.dao.UserDAO;
import ua.com.startup.investments.entities.User;
import java.util.ArrayList;
import java.util.List;

public class HibUser implements UserDAO<User, String, Integer> {

    private SessionFactory sessionFactory;

    public HibUser(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void createUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            session.save(user);
        } catch (Exception e) {
            System.out.println("Exception occurred while trying to save user " + user);
            e.printStackTrace();
        }
    }

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

    @Override
    public User findByName(String name) {
        User company = new User(0, name);
        try (Session session = sessionFactory.openSession()) {
            List<User> users = session.createQuery("select c from User c where c.name like :name")
                    .setParameter("name", name).list();
            if (users.size() != 0) {
                company = users.get(0);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while trying to find user with name: " + name);
            e.printStackTrace();
        }
        return company;
    }

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
            session.update(userFromDb);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Exception occurred while trying to update user " + user);
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

    @Override
    public void delete(Integer id) {
        Transaction transaction = null;
        try (Session session = sessionFactory.openSession()) {
            transaction = session.beginTransaction();
            User userFromDb = session.get(User.class, id);
            if (userFromDb == null) {
                return;
            }
            session.delete(userFromDb);
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Exception occurred while trying to delete user with id: " + id);
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        }
    }

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
