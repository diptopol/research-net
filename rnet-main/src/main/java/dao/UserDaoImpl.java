package dao;

import domain.User;
import exceptions.NoUserFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 9/30/13
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class UserDaoImpl implements UserDao{
    private static final Logger logger = LoggerFactory.getLogger(UserDaoImpl.class);

    @PersistenceContext(unitName = "persistDB")
    private EntityManager entityManager;

    @Override
    public User getUserBy(User user) throws NoUserFoundException{
       logger.info("UserDaoImpl :"+user.getUsername());

        List<User>validUsers = (List<User>) entityManager.createQuery("SELECT user FROM User user WHERE user.username =:username " +
                "AND user.password =:password").
                setParameter("username", user.getUsername()).
                setParameter("password", user.getPassword()).
                getResultList();

        if(validUsers.isEmpty()) {
            logger.info("UserDaoImpl :empty");
            throw new NoUserFoundException();
        }
        else {
            return validUsers.get(0);
        }



    }

    @Override
    public void insert(User user) {
        entityManager.persist(user);
    }
}
