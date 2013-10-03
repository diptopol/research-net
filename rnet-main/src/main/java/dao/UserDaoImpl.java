package dao;

import domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
    public User getUserBy(User user) {
        return (User) entityManager.createQuery("SELECT user FROM User user WHERE user.username =:username " +
                "AND user.password =:password").
                setParameter("username", user.getUsername()).
                setParameter("password", user.getPassword()).
                getSingleResult();
    }
}
