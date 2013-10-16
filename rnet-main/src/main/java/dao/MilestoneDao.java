package dao;

import domain.Milestone;
import domain.Research;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/8/13
 * Time: 1:40 PM
 * To change this template use File | Settings | File Templates.
 */
public interface MilestoneDao {
    public List<Milestone> findMilestoneListBy(int researchId);
    public void addMilestone(Milestone milestone, Research research);
}
