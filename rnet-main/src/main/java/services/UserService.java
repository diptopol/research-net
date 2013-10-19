package services;

import domain.User;
import domain.UserInformation;
import exceptions.DatabaseConnectionException;
import exceptions.NoUserFoundException;

import javax.ejb.Local;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/2/13
 * Time: 9:31 AM
 * To change this template use File | Settings | File Templates.
 */
@Local
public interface UserService {
    public User getValidUserBy(User user) throws NoUserFoundException;
    public void addNewUser(User user, UserInformation information) throws NoUserFoundException;
    public String findUserFullNameBy(int user_id);
    public UserInformation findUserInformationBy(int userId);
}
