package dao;

import domain.Feedback;
import domain.Report;
import domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/18/13
 * Time: 1:48 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FeedbackDao {
    public List<Feedback> findFeedbackListBy(int reportId);
    public void insert(User user, Report report, Feedback feedback);
}
