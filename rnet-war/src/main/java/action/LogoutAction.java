package action;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/19/13
 * Time: 3:22 PM
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class LogoutAction {
    public String logout() {
        return "login.xhtml";
    }
}
