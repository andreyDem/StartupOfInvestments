package ua.com.startup.investments.dao.jdbc;

import ua.com.startup.investments.dao.InvestmentDAO;
import ua.com.startup.investments.entities.Investment;

import java.io.Serializable;
import java.util.List;
import java.sql.*;

/**
 * Created by Aleksey on 12.06.2017.
 */
public class JdbcInvestmentDAO implements InvestmentDAO {

    private final static String CREATE = "INSERT INTO INVESTMENTS (PRICE) VALUE (?)";


    private final static String FIND_BY_ID = "SELECT * FROM INVESTMENTS, INVESTMENTS_PROJECTS, INVESTMENTS_USERS WHERE INVESTMENTS.ID =   ";
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
