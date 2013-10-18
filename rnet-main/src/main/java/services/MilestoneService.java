package services;

import domain.Milestone;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/8/13
 * Time: 2:20 PM
 * To change this template use File | Settings | File Templates.
 */

public interface MilestoneService {
    public List<Milestone> findMilestoneListBy(int researchId);
    public void addMilestoneList(List<Milestone>milestones, int researchId);
    public Milestone findIncompleteMilestoneBy(int researchId);
    public void updateMilestone(Milestone milestone);
    public boolean isAllMilestoneComplete(int researchId);
}
