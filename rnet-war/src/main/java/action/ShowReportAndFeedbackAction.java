package action;

import domain.Report;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import services.ReportService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.util.Map;

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
    private FacesContext facesContext;
    private Report report;
    @EJB
    private ReportService reportService;


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
    }
}
