package action;

import static utils.ConstantValues.RESEARCH_STATUS_INACTIVE;
import domain.Collaborator;
import domain.Research;
import domain.User;
import exceptions.NoResearchFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.ResearchService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/6/13
 * Time: 10:05 AM
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class CreateResearchProjectAction implements Serializable {
    private static final Logger logger = LoggerFactory.getLogger(CreateResearchProjectAction.class);
    private Research research;
    private Collaborator collaborator;
    private FacesContext facesContext;
    private HttpSession session;
    private int userId;

    @EJB
    private ResearchService researchService;

    @PostConstruct
    private void startUp() {
        if(research == null) {
            research = new Research();
        }
        if(collaborator == null) {
            collaborator = new Collaborator();
        }
        facesContext = FacesContext.getCurrentInstance();
        session = (HttpSession) facesContext.getExternalContext().getSession(false);
        userId = (Integer) session.getAttribute("userId");
    }

    public Research getResearch() {
        return research;
    }

    public void setResearch(Research research) {
        this.research = research;
    }

    public Collaborator getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(Collaborator collaborator) {
        this.collaborator = collaborator;
    }

    public String createResearchProject() {
        research.setResearchStatus(RESEARCH_STATUS_INACTIVE);
        try {
            int research_id = researchService.createResearchProject(research, collaborator,userId);
            return "showResearchProject.xhtml?research_id="+research_id+"&faces-redirect=true";
        }
        catch (NoResearchFoundException noResearch) {
            logger.debug(noResearch.getMessage());
            return "createResearchProject.xhtml";
        }
    }
}
