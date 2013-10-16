package action;

import static utils.Utils.isJoiningDateRemains;
import static utils.Utils.isUserEligibleToJoin;

import domain.Collaborator;
import domain.Research;
import domain.User;
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
import java.util.*;

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

    @EJB
    private ResearchService researchService;
    @EJB
    private CollaboratorService collaboratorService;
    @EJB
    private UserService userService;
    private int researchId;
    private FacesContext facesContext;
    private Research research;
    private List<Collaborator> collaboratorList;
    private List<String> collaboratorNameList;

    public List<String> getCollaboratorNameList() {
        return collaboratorNameList;
    }

    public List<Collaborator> getCollaboratorList() {
        return collaboratorList;
    }

    public void setCollaboratorList(List<Collaborator> collaboratorList) {
        this.collaboratorList = collaboratorList;
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
        Map<String,String> parameterMap = facesContext.getExternalContext().getRequestParameterMap();
        researchId = Integer.parseInt(parameterMap.get("research_id"));
        logger.info("ShowResearchProject :"+researchId);
        research = researchService.findResearchBy(researchId);
        collaboratorList = collaboratorService.findCollaboratorsBy(researchId);
        collaboratorNameList = new ArrayList<String>();
        for(Collaborator collaborator: collaboratorList) {
            int userId = collaborator.getUser().getUserId();
            String fullName = userService.findUserFullNameBy(userId);
            collaboratorNameList.add(fullName);
        }

    }

    public boolean isVisible() {
        User user = new User();
        user.setUserId(2);
        user.setUsername("dipto");
        user.setPassword("therap");

        if(isJoiningDateRemains(research.getStartingTime()) && isUserEligibleToJoin(user.getUserId(), collaboratorList))
            return true;
        else return false;
    }

    public String goResearchProjectOverview() {
        return "showResearchProject.xhtml?research_id="+researchId+"&faces-redirect=true";
    }

    public String goMilestoneView() {
        return "showMilestone.xhtml?research_id="+researchId;
    }

}
