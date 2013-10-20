package dao;

import domain.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.TargetsContainer;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.junit.InSequence;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 9/30/13
 * Time: 1:30 PM
 * To change this template use File | Settings | File Templates.
 */
/*
@RunWith(Arquillian.class)
public class TestUserDao {
    @PersistenceContext
    EntityManager entityManager;
    @Inject
    UserTransaction transaction;

    private Map<String, String> userList;

    @Deployment
    public static Archive<?> createDeployment() {
        Archive archive = ShrinkWrap.create(WebArchive.class, "user-dao.war")
                .addPackage(User.class.getPackage())
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");

        System.out.println("UserDaoPersistenceTest: " + archive.toString(true));
        return archive;
    }

    @Before
    public void prepareTest() {
        System.out.println("before");
        prepareData();
        try {
            insertData();
        }
        catch (Exception exception) {
            System.out.println("insert Exception"+exception);
        }

    }

    private void prepareData() {
        System.out.println("prepare");
        userList = new HashMap<String, String>();
        userList.put("dipto", "therap");

    }

    private void insertData() throws Exception {
        transaction.begin();
        entityManager.joinTransaction();
        for (Object key : userList.keySet()) {
            User user = new User();
            user.setUsername(key.toString());
            user.setPassword(userList.get(key));
            entityManager.persist(user);
        }

        transaction.commit();
        entityManager.clear();
    }

    @Test
    @InSequence(2)
    public void getUserByIdReturnUsername() {
        String username = "dipto";

        User user = entityManager.createQuery("SELECT u " +
                "FROM User u " +
                "WHERE u.username = :username",
                User.class)
                .setParameter("username", username)
                .getSingleResult();
        System.out.println(user.getUsername());
        assertEquals(1, user.getUserId());
    }

    @Test
    @InSequence(1)
    public void testGetUserById() {
        User user = entityManager.find(User.class, 1);
        assertNotNull(user);
    }


}
*/
