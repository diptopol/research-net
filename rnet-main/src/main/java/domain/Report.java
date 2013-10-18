package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/3/13
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "report")
public class Report implements Serializable{
    @Id @GeneratedValue
    @Column(name = "report_id")
    private Integer reportId;
    @Column(name = "report_status")
    private String reportStatus;
    @Column(name = "reporting_time")
    private Date reportingTime;
    @Lob
    @Column(name = "report_data")
    private byte[] reportData;
    @ManyToOne(targetEntity = User.class)
    @JoinTable(name = "user_report",
            joinColumns = {@JoinColumn(name = "report_id", insertable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "user_id", insertable = false, updatable = false)})
    private User user;
    @ManyToOne(targetEntity = Milestone.class)
    @JoinTable(name = "milestone_report",
            joinColumns = {@JoinColumn(name = "report_id", insertable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "milestone_id", insertable = false, updatable = false)})
    private Milestone milestone;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "report_feedback",
            joinColumns = {@JoinColumn(name = "report_id")},
            inverseJoinColumns = {@JoinColumn(name = "feedback_id")})
    private List<Feedback> feedbackList;

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public Milestone getMilestone() {
        return milestone;
    }

    public void setMilestone(Milestone milestone) {
        this.milestone = milestone;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public byte[] getReportData() {
        return reportData;
    }

    public void setReportData(byte[] reportData) {
        this.reportData = reportData;
    }

    public Date getReportingTime() {
        return reportingTime;
    }

    public void setReportingTime(Date reportingTime) {
        this.reportingTime = reportingTime;
    }

    public String getReportStatus() {
        return reportStatus;
    }

    public void setReportStatus(String reportStatus) {
        this.reportStatus = reportStatus;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }
}
