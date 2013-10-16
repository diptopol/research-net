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
    @EJB
    private MilestoneService milestoneService;

    @PostConstruct
    private void startUp() {
        facesContext = FacesContext.getCurrentInstance();
        Map<String,String> parameterMap = facesContext.getExternalContext().getRequestParameterMap();
        researchId = Integer.parseInt(parameterMap.get("research_id"));
    }

    public List<Milestone> showMilestoneList() {
      return milestoneService.findMilestoneListBy(researchId);
    }



}
