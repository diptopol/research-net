package action;

import domain.Research;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.ResearchService;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/17/13
 * Time: 9:54 AM
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class ShowResearchFeedAction {
    private static final Logger logger = LoggerFactory.getLogger(ShowResearchFeedAction.class);
    private List<Research> researchList;
    @EJB
    private ResearchService researchService;

    public List<Research> getResearchList() {
        researchList = researchService.findResearchList(0);
        return researchList;
    }

    public void setResearchList(List<Research> researchList) {
        this.researchList = researchList;
    }
}
