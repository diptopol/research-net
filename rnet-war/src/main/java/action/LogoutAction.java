package action;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

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
    private FacesContext facesContext;
    private HttpSession session;

    public String logout() {
        facesContext = FacesContext.getCurrentInstance();
        session = (HttpSession) facesContext.getExternalContext().getSession(false);
        session.invalidate();
        return "login.xhtml?faces-redirect=true";
    }
}
