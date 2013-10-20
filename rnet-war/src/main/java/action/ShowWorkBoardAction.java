package action;

import static utils.Utils.getSystemDate;
import static utils.ConstantValues.REPORT_UNACCEPTED;

import domain.Milestone;
import domain.Report;
import domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.MilestoneService;
import services.ReportService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/17/13
 * Time: 2:06 PM
 * To change this template use File | Settings | File Templates.
 */
@Named
@RequestScoped
public class ShowWorkBoardAction {
    private static final Logger logger = LoggerFactory.getLogger(ShowWorkBoardAction.class);
    private int researchId;
    private FacesContext facesContext;
    private Report report;
    private HttpSession session;
    private int userId;
    private List<Report> previousReportList;
    private Milestone currentMilestone;
    @EJB
    private ReportService reportService;
    @EJB
    private MilestoneService milestoneService;

    public List<Report> getPreviousReportList() {
        previousReportList = reportService.findReportListBy(researchId);
        return previousReportList;
    }

    public void setPreviousReportList(List<Report> previousReportList) {
        this.previousReportList = previousReportList;
    }

    public Milestone getCurrentMilestone() {
        return currentMilestone;
    }

    public void setCurrentMilestone(Milestone currentMilestone) {
        this.currentMilestone = currentMilestone;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public int getResearchId() {
        return researchId;
    }

    public void setResearchId(int researchId) {
        this.researchId = researchId;
    }

    @PostConstruct
    private void startUp() {
        if(report == null) {
            report = new Report();
        }
        facesContext = FacesContext.getCurrentInstance();
        Map<String,String> parameterMap = facesContext.getExternalContext().getRequestParameterMap();
        if(parameterMap.containsKey("research_id"))
            researchId = Integer.parseInt(parameterMap.get("research_id"));
        currentMilestone = milestoneService.findIncompleteMilestoneBy(researchId);
        session = (HttpSession) facesContext.getExternalContext().getSession(false);
        userId = (Integer) session.getAttribute("userId");

    }

    public String submitReport() {
        logger.info("showWorkBoard :submitReport");
        Date submitTime = getSystemDate();
        report.setReportingTime(submitTime);
        report.setReportStatus(REPORT_UNACCEPTED);

        reportService.insertReport(userId, currentMilestone, report);
        return "showWorkBoard.xhtml?research_id="+researchId+"&faces-redirect=true";
    }
}
