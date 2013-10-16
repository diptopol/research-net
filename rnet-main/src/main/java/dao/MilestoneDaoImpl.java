package dao;

import domain.Milestone;
import domain.Research;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/8/13
 * Time: 1:40 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class MilestoneDaoImpl implements MilestoneDao {
    private static final Logger logger = LoggerFactory.getLogger(MilestoneDaoImpl.class);
    @PersistenceContext(unitName = "persistDB")
    EntityManager entityManager;

    private Research findResearchWithMilestoneBy(int researchId) {
        List<Research> researchList = (List<Research>) entityManager.createQuery("SELECT research FROM Research research " +
                "LEFT JOIN FETCH research.milestoneList milestone " +
                "WHERE research.researchId =:id").setParameter("id", researchId).getResultList();

        return researchList.get(0);
    }

    public List<Milestone> findMilestoneListBy(int researchId) {
        return entityManager.createQuery("SELECT milestone FROM Milestone milestone WHERE " +
                "milestone.research.researchId =:id")
                .setParameter("id", researchId)
                .getResultList();
    }

    public void addMilestone(Milestone milestone, Research research) {
        List<Milestone> oldMilestoneList = findMilestoneListBy(research.getResearchId());
        if(oldMilestoneList == null) {
            oldMilestoneList = new ArrayList<Milestone>();
        }
        oldMilestoneList.add(milestone);
        research.setMilestoneList(oldMilestoneList);
    }
}
