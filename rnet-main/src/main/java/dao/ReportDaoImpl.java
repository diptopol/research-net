package dao;

import domain.Milestone;
import domain.Report;
import domain.User;
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
 * Date: 10/17/13
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class ReportDaoImpl implements ReportDao{
    private static final Logger logger = LoggerFactory.getLogger(ReportDaoImpl.class);
    @PersistenceContext(unitName = "persistDB")
    EntityManager entityManager;

    private List<Report> findReportListByMilestone(int milestoneId) {
        return entityManager.createQuery("SELECT report FROM Report report WHERE " +
                "report.milestone.milestoneId =:id")
                .setParameter("id", milestoneId)
                .getResultList();
    }

    private List<Report> findReportListByUser(int userId) {
        return entityManager.createQuery("SELECT report FROM Report report WHERE " +
                "report.user.userId =:id")
                .setParameter("id", userId)
                .getResultList();
    }

    @Override
    public void insert(User user, Milestone milestone, Report report) {
        logger.info("ReportDaoImpl :milestone_id "+milestone.getMilestoneId());

        List<Report> userReportList = findReportListByUser(user.getUserId());
        if(userReportList == null) {
            userReportList = new ArrayList<Report>();
        }
        userReportList.add(report);
        user.setReportList(userReportList);

        List<Report> milestoneReportList = findReportListByMilestone(milestone.getMilestoneId());
        if(milestoneReportList == null) {
            milestoneReportList = new ArrayList<Report>();
        }
        milestoneReportList.add(report);
        milestone.setReportList(milestoneReportList);
        entityManager.merge(milestone);
    }

    @Override
    public List<Report> findReportListBy(int researchId) {
        return entityManager.createQuery("SELECT report FROM Report report WHERE " +
                "report.milestone.research.researchId =:id ORDER BY report.reportingTime DESC")
                .setParameter("id", researchId).getResultList();
    }

    @Override
    public Report findReportBy(int reportId) {
        return entityManager.find(Report.class, reportId);
    }

    @Override
    public void updateReport(Report report) {
        entityManager.merge(report);
    }
}
