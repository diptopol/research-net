package services;

import domain.User;
import exceptions.NoUserFoundException;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/2/13
 * Time: 9:31 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserService {
    public User getValidUserBy(User user) throws NoUserFoundException;
}
