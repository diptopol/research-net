package dao;

import domain.User;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 9/30/13
 * Time: 11:57 AM
 * To change this template use File | Settings | File Templates.
 */
public interface UserDao {
    User getUserBy(User user);
}
