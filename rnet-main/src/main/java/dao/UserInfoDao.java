package dao;

import domain.User;
import domain.UserInformation;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/4/13
 * Time: 11:28 PM
 * To change this template use File | Settings | File Templates.
 */
public interface UserInfoDao {
    public void insert(User user, UserInformation information);
}
