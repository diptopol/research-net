package services;

import dao.MilestoneDao;
import dao.ReportDao;
import dao.UserDao;
import domain.Milestone;
import domain.Report;
import domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/17/13
 * Time: 4:41 PM
 * To change this template use File | Settings | File Templates.
 */
@Stateless
public class ReportServiceImpl implements ReportService {
    private static final Logger logger = LoggerFactory.getLogger(ReportService.class);
    @EJB
    private UserDao userDao;
    @EJB
    private ReportDao reportDao;

    @Override
    @TransactionAttribute
    public void insertReport(int userId, Milestone milestone, Report report) {
        logger.info("ReportServiceImpl :reportDate "+report.getReportingTime());
        User user = userDao.findUserBy(userId);
        reportDao.insert(user, milestone, report);
    }

    @Override
    public List<Report> findReportListBy(int researchId) {
        return reportDao.findReportListBy(researchId);
    }

    @Override
    public Report findReportBy(int reportId) {
        return reportDao.findReportBy(reportId);
    }
}
