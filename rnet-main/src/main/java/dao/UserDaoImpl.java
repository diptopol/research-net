package dao;

import domain.User;
import exceptions.DatabaseConnectionException;
import exceptions.NoUserFoundException;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 9/30/13
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class UserDaoImpl implements UserDao{

    @PersistenceContext(unitName = "persistDB")
    private EntityManager entityManager;

    @Override
    public User getUserBy(User user) throws NoUserFoundException{
        User validUser = null;
        try {
            validUser = (User) entityManager.createQuery("SELECT user FROM User user WHERE user.username =:username " +
                    "AND user.password =:password").
                    setParameter("username", user.getUsername()).
                    setParameter("password", user.getPassword()).
                    getSingleResult();
        }
        catch (NoResultException noResult) {
        }
        if(user == null) {
            throw new NoUserFoundException();
        }
        return validUser;
    }

    @Override
    public void insert(User user) {
        entityManager.persist(user);
    }
}
