package action;

import domain.Research;
import domain.UserInformation;
import services.ResearchService;
import services.UserService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/19/13
 * Time: 4:14 AM
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class ShowProfileAction {
    private UserInformation userInformation;
    private FacesContext facesContext;
    private List<Research> currentResearchList;
    private List<Research> previousResearchList;
    private int userId;
    @EJB
    private UserService userService;
    @EJB
    private ResearchService researchService;

    public List<Research> getPreviousResearchList() {
        previousResearchList = researchService.findCompleteResearchListBy(userId);
        return previousResearchList;
    }

    public void setPreviousResearchList(List<Research> previousResearchList) {
        this.previousResearchList = previousResearchList;
    }

    public List<Research> getCurrentResearchList() {
        currentResearchList = researchService.findIncompleteResearchListBy(userId);
        return currentResearchList;
    }

    public void setCurrentResearchList(List<Research> currentResearchList) {
        this.currentResearchList = currentResearchList;
    }

    public UserInformation getUserInformation() {
        userInformation = userService.findUserInformationBy(userId);
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    @PostConstruct
    private void startUp() {
        facesContext = FacesContext.getCurrentInstance();
        Map<String,String> parameterMap = facesContext.getExternalContext().getRequestParameterMap();
        if(parameterMap.containsKey("user_id"))
            userId = Integer.parseInt(parameterMap.get("user_id"));
    }
}
