package action;

import domain.User;
import exceptions.DatabaseConnectionException;
import exceptions.NoUserFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/2/13
 * Time: 9:50 AM
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class LoginAction implements Serializable{
    private static final Logger logger = LoggerFactory.getLogger(LoginAction.class);
    private User user = null;
    private FacesContext facesContext;
    private ExternalContext externalContext;
    private HttpSession session;
    @EJB
    private UserService userService;


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
        try {
            logger.info("login :"+user.getUsername());
            user = userService.getValidUserBy(user);
            facesContext = FacesContext.getCurrentInstance();
            externalContext = facesContext.getExternalContext();
            session = (HttpSession) externalContext.getSession(true);
            session.setAttribute("userId", user.getUserId());
            return "showResearchFeed.xhtml?faces-redirect=true";
        }
        catch (NoUserFoundException noUser) {
            return "login.xhtml?error=no_user&faces-redirect=true";
        }
    }
}
