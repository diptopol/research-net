package action;

import domain.User;
import domain.UserInformation;
import exceptions.NoUserFoundException;
import services.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.inject.Named;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/4/13
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class RegisterAction {
    private User user;
    private UserInformation userInformation;
    private UIComponent passwordComponent;
    @EJB
    private UserService userService;

    @PostConstruct
    private void startUp() {
        user = new User();
        userInformation = new UserInformation();
    }

    public UIComponent getPasswordComponent() {
        return passwordComponent;
    }

    public void setPasswordComponent(UIComponent passwordComponent) {
        this.passwordComponent = passwordComponent;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public String registration() {
        try {
            userService.addNewUser(user, userInformation);
        }
        catch (NoUserFoundException noUser) {
            noUser.printStackTrace();
        }

        return "login";
    }


}
