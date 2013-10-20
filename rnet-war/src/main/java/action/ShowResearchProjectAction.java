package action;

import static utils.ConstantValues.RESEARCH_STATUS_ACTIVE;
import domain.Collaborator;
import domain.Research;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.CollaboratorService;
import services.ResearchService;
import services.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static utils.Utils.isJoiningDateRemains;
import static utils.Utils.isNotACollaborator;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/7/13
 * Time: 10:43 PM
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class ShowResearchProjectAction {
    private static final Logger logger = LoggerFactory.getLogger(ShowResearchProjectAction.class);
    private int researchId;
    private FacesContext facesContext;
    private Research research;
    private List<Collaborator> collaboratorList;
    private List<String> collaboratorNameList;
    private HttpSession session;
    private int userId;
    private Collaborator newCollaborator;

    @EJB
    private ResearchService researchService;
    @EJB
    private CollaboratorService collaboratorService;
    @EJB
    private UserService userService;

    public int getResearchId() {
        return researchId;
    }

    public void setResearchId(int researchId) {
        this.researchId = researchId;
    }

    public List<String> getCollaboratorNameList() {
        return collaboratorNameList;
    }

    public Research getResearch() {
        return research;
    }

    public void setResearch(Research research) {
        this.research = research;
    }

    @PostConstruct
    private void startUp() {
        facesContext = FacesContext.getCurrentInstance();
        session = (HttpSession) facesContext.getExternalContext().getSession(false);
        userId = (Integer) session.getAttribute("userId");

        Map<String,String> parameterMap = facesContext.getExternalContext().getRequestParameterMap();
        if(parameterMap.containsKey("research_id"))   {
            researchId = Integer.parseInt(parameterMap.get("research_id"));
            research = researchService.findResearchBy(researchId);
            collaboratorList = collaboratorService.findCollaboratorsBy(researchId);
            collaboratorNameList = new ArrayList<String>();
            for(Collaborator collaborator: collaboratorList) {
                int userId = collaborator.getUser().getUserId();
                String fullName = userService.findUserFullNameBy(userId);
                collaboratorNameList.add(fullName);
            }
        }
    }

    public boolean isMenuVisible() {

        if(research.getResearchStatus().equals(RESEARCH_STATUS_ACTIVE) && !isNotACollaborator(userId, collaboratorList)) {
             return true;
        }
        else return false;
    }

    public boolean isVisible() {
        if(isJoiningDateRemains(research.getStartingTime()) && isNotACollaborator(userId, collaboratorList))
            return true;
        else return false;
    }


}
