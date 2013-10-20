package services;

import dao.FeedbackDao;
import dao.ReportDao;
import dao.UserDao;
import domain.Feedback;
import domain.Report;
import domain.User;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/18/13
 * Time: 1:48 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class FeedbackServiceImpl implements FeedbackService {

    @EJB
    private FeedbackDao feedbackDao;
    @EJB
    private UserDao userDao;
    @EJB
    private ReportDao reportDao;

    @Override
    public List<Feedback> findFeedbackListBy(int reportId) {
        return feedbackDao.findFeedbackListBy(reportId);
    }

    @Override
    @TransactionAttribute
    public void insertFeedback(int userId, int reportId, Feedback feedback) {
        User user = userDao.findUserBy(userId);
        Report report = reportDao.findReportBy(reportId);
        feedbackDao.insert(user, report, feedback);
    }
}
