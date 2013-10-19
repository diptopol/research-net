package action;

import domain.User;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

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
    private FacesContext facesContext;
    private HttpSession session;
    private int userId;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @PostConstruct
    private void startUp() {
        facesContext = FacesContext.getCurrentInstance();
        session = (HttpSession) facesContext.getExternalContext().getSession(false);
        userId = (Integer) session.getAttribute("userId");
    }
}
