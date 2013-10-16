package action;

import domain.Milestone;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.MilestoneService;

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
 * Date: 10/8/13
 * Time: 1:28 PM
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class ShowMilestoneAction {
    private static final Logger logger = LoggerFactory.getLogger(ShowMilestoneAction.class);
    private int researchId;
    private FacesContext facesContext;
    private List<Milestone> milestoneList;
    @EJB
    private MilestoneService milestoneService;

    public int getResearchId() {
        return researchId;
    }

    public void setResearchId(int researchId) {
        this.researchId = researchId;
    }

    public List<Milestone> getMilestoneList() {
        milestoneList =  milestoneService.findMilestoneListBy(researchId);
        return milestoneList;
    }

    public void setMilestoneList(List<Milestone> milestoneList) {
        this.milestoneList = milestoneList;
    }

    @PostConstruct
    private void startUp() {
        facesContext = FacesContext.getCurrentInstance();
        Map<String,String> parameterMap = facesContext.getExternalContext().getRequestParameterMap();
        if(parameterMap.containsKey("research_id"))
            researchId = Integer.parseInt(parameterMap.get("research_id"));
    }

    public String addMilestone() {
        return "addMilestone.xhtml?research_id="+researchId+"&faces-redirect=true";
    }







}
