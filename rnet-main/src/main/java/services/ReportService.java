package services;

import domain.Milestone;
import domain.Report;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/17/13
 * Time: 4:38 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ReportService {
    public void insertReport(int userId, Milestone milestone, Report report);
    public List<Report> findReportListBy(int researchId);
    public Report findReportBy(int reportId);
    public void updateReport(Report report);
}
