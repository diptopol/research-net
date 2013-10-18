package dao;

import domain.Feedback;
import domain.Report;
import domain.User;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/18/13
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class FeedbackDaoImpl implements FeedbackDao {
    @PersistenceContext(unitName = "persistDB")
    EntityManager entityManager;

    private List<Feedback> findFeedbackListByReport(int reportId) {
        return entityManager.createQuery("SELECT feedback FROM Feedback feedback WHERE " +
                "feedback.report.reportId =:id")
                .setParameter("id", reportId)
                .getResultList();
    }

    private List<Feedback> findFeedbackListByUser(int userId) {
        return entityManager.createQuery("SELECT feedback FROM Feedback feedback WHERE " +
                "feedback.user.userId =:id")
                .setParameter("id", userId)
                .getResultList();
    }

    @Override
    public List<Feedback> findFeedbackListBy(int reportId) {
        return entityManager.createQuery("SELECT feedback FROM Feedback feedback " +
                "WHERE feedback.report.reportId =:id ORDER BY feedback.feedbackTime DESC")
                .setParameter("id", reportId)
                .getResultList();
    }

    @Override
    public void insert(User user, Report report, Feedback feedback) {
        List<Feedback> userFeedbackList = findFeedbackListByUser(user.getUserId());
        if(userFeedbackList == null) {
            userFeedbackList = new ArrayList<Feedback>();
        }
        userFeedbackList.add(feedback);
        user.setFeedbackList(userFeedbackList);

        List<Feedback> reportFeedbackList = findFeedbackListByReport(report.getReportId());
        if(reportFeedbackList == null) {
            reportFeedbackList = new ArrayList<Feedback>();
        }
        reportFeedbackList.add(feedback);
        report.setFeedbackList(reportFeedbackList);
    }
}
