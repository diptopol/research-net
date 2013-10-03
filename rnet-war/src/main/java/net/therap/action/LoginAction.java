package net.therap.action;

import domain.User;
import exceptions.NoUserFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/2/13
 * Time: 9:50 AM
 * To change this template use File | Settings | File Templates.
 */
@Named
@SessionScoped
public class LoginAction implements Serializable{
    Logger logger = LoggerFactory.getLogger(LoginAction.class);

    @EJB
    private UserService userService;
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @PostConstruct
    private void startUp() {
        if(user == null) {
            user = new User();
        }
    }

    public String login() {
        user.setUsername("dipto");
        user.setPassword("therap");
        try {
            user = userService.getValidUserBy(user);
        }
        catch (NoUserFoundException noUser) {
            System.out.println(noUser);
        }
        return "login";
    }







}
