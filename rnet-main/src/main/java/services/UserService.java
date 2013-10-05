package services;

import domain.User;
import domain.UserInformation;
import exceptions.DatabaseConnectionException;
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
    public void addNewUser(User user, UserInformation information) throws NoUserFoundException;
}
