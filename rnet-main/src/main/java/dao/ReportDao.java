package dao;

import domain.Milestone;
import domain.Report;
import domain.User;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/17/13
 * Time: 4:50 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ReportDao {
    public void insert(User user, Milestone milestone, Report report);
    public List<Report> findReportListBy(int researchId);
    public Report findReportBy(int reportId);
    public void updateReport(Report report);
}
