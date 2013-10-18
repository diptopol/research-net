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
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static utils.ConstantValues.MILESTONE_INCOMPLETE;
import static utils.ConstantValues.NUMBER_OF_ADD_MILESTONES_IN_ONE_PAGE;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/9/13
 * Time: 4:22 PM
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class AddMilestoneAction implements Serializable{
    private static final Logger logger = LoggerFactory.getLogger(AddMilestoneAction.class);

    private FacesContext facesContext;

    @EJB
    private MilestoneService milestoneService;
    private List<Milestone> milestoneList;
    private int researchId;

    public int getResearchId() {
        return researchId;
    }

    public void setResearchId(int researchId) {
        this.researchId = researchId;
    }

    public List<Milestone> getMilestoneList() {
        return generateMilestoneList();
    }

    public void setMilestoneList(List<Milestone> milestoneList) {
        this.milestoneList = milestoneList;
    }

    @PostConstruct
    private void startup() {
        logger.info("startup");
        facesContext = FacesContext.getCurrentInstance();
        Map<String,String> parameterMap = facesContext.getExternalContext().getRequestParameterMap();
        if(parameterMap.containsKey("research_id")) {
            researchId = Integer.parseInt(parameterMap.get("research_id"));
            logger.info("researchId :" + researchId);
        }
    }

    private List<Milestone> generateMilestoneList() {
        List<Milestone> oldMilestoneList = milestoneService.findMilestoneListBy(researchId);
        logger.info("addMilestoneAction oldMilestone:"+oldMilestoneList.size());
        milestoneList = new ArrayList<Milestone>();
        int current_sequence = oldMilestoneList.size()+1;
        for(int iterator = 0; iterator < NUMBER_OF_ADD_MILESTONES_IN_ONE_PAGE ; iterator++) {
            Milestone milestone = new Milestone();
            milestone.setSequence(current_sequence++);
            milestone.setMilestoneStatus(MILESTONE_INCOMPLETE);
            milestoneList.add(milestone);
        }
        return milestoneList;
    }

    public String addMilestone() {
        logger.info("addMilestone researchId :" + researchId);
        milestoneService.addMilestoneList(milestoneList, researchId);
        return "showMilestone.xhtml?research_id="+researchId+"&faces-redirect=true";
    }
}
