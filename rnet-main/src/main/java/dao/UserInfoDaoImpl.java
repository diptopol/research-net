package dao;

import domain.User;
import domain.UserInformation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/4/13
 * Time: 11:30 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class UserInfoDaoImpl implements UserInfoDao {

    @PersistenceContext(unitName = "persistDB")
    private EntityManager entityManager;

    @Override
    public void insert(User user, UserInformation information) {
        user.setUserInformation(information);
        information.setUser(user);
        entityManager.merge(user);
    }
}
