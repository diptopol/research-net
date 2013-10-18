package services;

import domain.Feedback;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/18/13
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
public interface FeedbackService {
    public List<Feedback> findFeedbackListBy(int reportId);
    public void insertFeedback(int userId, int reportId, Feedback feedback);
}
