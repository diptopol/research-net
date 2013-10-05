package dao;

import domain.User;
import exceptions.DatabaseConnectionException;
import exceptions.NoUserFoundException;

import javax.persistence.NoResultException;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 9/30/13
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {
    public User getUserBy(User user) throws NoUserFoundException;
    public void insert(User user);

}
