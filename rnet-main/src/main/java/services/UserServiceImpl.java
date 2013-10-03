package services;

import dao.UserDao;
import domain.User;
import exceptions.NoUserFoundException;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/2/13
 * Time: 9:34 AM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class UserServiceImpl implements UserService {

    @EJB
    private UserDao userDao;
    @Override
    public User getValidUserBy(User user) throws NoUserFoundException{
        user = userDao.getUserBy(user);
        if(user == null) {
            throw new NoUserFoundException();
        }
        else return user;
    }
}
