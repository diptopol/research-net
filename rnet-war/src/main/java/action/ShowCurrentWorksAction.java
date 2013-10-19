package action;

import domain.Research;
import services.ResearchService;

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
 * Time: 1:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class ShowCurrentWorksAction {
    private FacesContext facesContext;
    private List<Research> currentResearchList;
    private int userId;
    @EJB
    private ResearchService researchService;

    public List<Research> getCurrentResearchList() {
        currentResearchList = researchService.findIncompleteResearchListBy(userId);
        return currentResearchList;
    }

    public void setCurrentResearchList(List<Research> currentResearchList) {
        this.currentResearchList = currentResearchList;
    }

    @PostConstruct
    private void startUp() {
        facesContext = FacesContext.getCurrentInstance();
        Map<String,String> parameterMap = facesContext.getExternalContext().getRequestParameterMap();
        if(parameterMap.containsKey("user_id"))
            userId = Integer.parseInt(parameterMap.get("user_id"));
    }
}
