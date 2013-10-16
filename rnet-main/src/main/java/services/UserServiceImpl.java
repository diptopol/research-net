package services;

import dao.UserDao;
import dao.UserInfoDao;
import domain.User;
import domain.UserInformation;
import exceptions.NoUserFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/2/13
 * Time: 9:34 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @EJB
    private UserDao userDao;
    @EJB
    private UserInfoDao userInfoDao;

    @Override
    public User getValidUserBy(User user) throws NoUserFoundException {
        logger.info("userService");
        return userDao.getUserBy(user);
    }

    @Override
    @TransactionAttribute
    public void addNewUser(User user, UserInformation information) throws NoUserFoundException {
        userDao.insert(user);
        user = userDao.getUserBy(user);
        userInfoDao.insert(user, information);
    }

    public String findUserFullNameBy(int user_id) {
        return userInfoDao.findUserFullNameBy(user_id);
    }
}
