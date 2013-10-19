package action;

import domain.User;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/19/13
 * Time: 4:08 AM
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class SideMenuAction {
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @PostConstruct
    private void startUp() {
        userId=1;
    }
}
