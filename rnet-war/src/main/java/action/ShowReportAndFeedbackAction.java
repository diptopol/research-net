package action;

import domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.*;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static utils.ConstantValues.*;
import static utils.Utils.getSystemDate;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/18/13
 * Time: 12:43 PM
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class ShowReportAndFeedbackAction {
    private static final Logger logger = LoggerFactory.getLogger(ShowReportAndFeedbackAction.class);
    private int reportId;
    private int researchId;
    private FacesContext facesContext;
    private Report report;
    private User user;
    private List<Feedback> feedbackList;
    private Feedback feedback;
    @EJB
    private MilestoneService milestoneService;
    @EJB
    private ReportService reportService;
    @EJB
    private FeedbackService feedbackService;
    @EJB
    private CollaboratorService collaboratorService;
    @EJB
    private ResearchService researchService;

    public Feedback getFeedback() {
        return feedback;
    }

    public void setFeedback(Feedback feedback) {
        this.feedback = feedback;
    }

    public int getResearchId() {
        return researchId;
    }

    public void setResearchId(int researchId) {
        this.researchId = researchId;
    }

    public List<Feedback> getFeedbackList() {
        feedbackList = feedbackService.findFeedbackListBy(reportId);
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public Report getReport() {
        report = reportService.findReportBy(reportId);
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    @PostConstruct
    private void startUp() {
        facesContext = FacesContext.getCurrentInstance();
        Map<String,String> parameterMap = facesContext.getExternalContext().getRequestParameterMap();
        if(parameterMap.containsKey("report_id"))
            reportId = Integer.parseInt(parameterMap.get("report_id"));
        if(parameterMap.containsKey("research_id"))
            researchId = Integer.parseInt(parameterMap.get("research_id"));
        if(feedback == null) {
            feedback = new Feedback();
        }

        user = new User();
        user.setUserId(1);
        user.setUsername("dipto");
        user.setPassword("therap");


    }

    public boolean isButtonVisible() {
        Collaborator collaborator = collaboratorService.findCollaboratorBy(researchId, user.getUserId());
        report = getReport();
        logger.info("showReport :" + collaborator.getRole()+REPORT_UNACCEPTED+report.getReportStatus()+ROLE_MENTOR);
        if(report.getReportStatus().equals(REPORT_UNACCEPTED) && collaborator.getRole().equals(ROLE_MENTOR)) {
            logger.info("showReport :" + collaborator.getRole()+report.getReportStatus());
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isTextVisible() {
        if(report.getReportStatus().equals(REPORT_ACCEPTED)) {
            return true;
        }
        else {
            return false;
        }
    }

    public String stateChange() {
        report.setReportStatus(REPORT_ACCEPTED);
        reportService.updateReport(report);
        Milestone milestone = report.getMilestone();
        milestone.setMilestoneStatus(MILESTONE_COMPLETE);
        milestoneService.updateMilestone(milestone);
        boolean isProjectComplete = milestoneService.isAllMilestoneComplete(researchId);
        if(isProjectComplete == true) {
            Research research = researchService.findResearchBy(researchId);
            research.setResearchStatus(RESEARCH_STATUS_COMPLETE);
            researchService.updateResearch(research);
        }
        return "showReport.xhtml?report_id="+reportId+"&research_id="+researchId+"&faces-redirect=true";
    }

    public String submitFeedback() {
        Date submitTime = getSystemDate();
        feedback.setFeedbackTime(submitTime);

        feedbackService.insertFeedback(user.getUserId(), reportId, feedback);
        return "showReport.xhtml?report_id="+reportId+"&research_id="+researchId+"&faces-redirect=true";
    }
}
