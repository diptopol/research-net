package services;

import dao.MilestoneDao;
import dao.ResearchDao;
import domain.Milestone;
import domain.Research;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/8/13
 * Time: 2:20 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class MilestoneServiceImpl implements MilestoneService{
    @EJB
    private MilestoneDao milestoneDao;
    @EJB
    private ResearchDao researchDao;


    public List<Milestone> findMilestoneListBy(int researchId) {
        return milestoneDao.findMilestoneListBy(researchId);
    }

    @TransactionAttribute
    public void addMilestoneList(List<Milestone>milestones, int researchId) {
        Research research = researchDao.findResearchBy(researchId);
        for(Milestone milestone : milestones ) {
            milestoneDao.addMilestone(milestone, research);
        }
    }

    public Milestone findIncompleteMilestoneBy(int researchId) {
       return milestoneDao.findIncompleteMilestoneBy(researchId);
    }
}
