package action;

import static utils.ConstantValues.ROLE_MENTOR;
import domain.Collaborator;
import domain.Research;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.CollaboratorService;
import services.ResearchService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/20/13
 * Time: 1:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class JoinAsCollaboratorAction {
    private static Logger logger = LoggerFactory.getLogger(JoinAsCollaboratorAction.class);
    private FacesContext facesContext;
    private HttpSession session;
    private int userId;
    private int researchId;
    private List<Collaborator> collaboratorList;
    private Collaborator collaborator;
    private Research research;
    @EJB
    private CollaboratorService collaboratorService;
    @EJB
    private ResearchService researchService;

    public Collaborator getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(Collaborator collaborator) {
        this.collaborator = collaborator;
    }

    public Research getResearch() {
        research = researchService.findResearchBy(researchId);
        return research;
    }

    public void setResearch(Research research) {
        this.research = research;
    }

    @PostConstruct
    private void startUp() {
        if(collaborator == null) {
            collaborator = new Collaborator();
        }
        facesContext = FacesContext.getCurrentInstance();
        session = (HttpSession) facesContext.getExternalContext().getSession(false);
        userId = (Integer) session.getAttribute("userId");

        Map<String,String> parameterMap = facesContext.getExternalContext().getRequestParameterMap();
        if(parameterMap.containsKey("research_id"))   {
            researchId = Integer.parseInt(parameterMap.get("research_id"));
        }
    }

    public String joinAsCollaborator() {
        collaboratorService.CollaboratorInsert(researchId, collaborator, userId);
        return "showResearchProject.xhtml?research_id="+researchId+"&faces-redirect=true";
    }

    public boolean isEligibleForMentor() {
        boolean isEligibleForMentor = true;
        collaboratorList = collaboratorService.findCollaboratorsBy(researchId);
        logger.info("JoinAsCollaborator :"+collaboratorList);
        for(Collaborator collaborator: collaboratorList) {
            String collaborator_user_role = collaborator.getRole();
            if(collaborator_user_role.equals(ROLE_MENTOR)) {
                isEligibleForMentor = false;
                break;
            }
        }
        return isEligibleForMentor;
    }
}
