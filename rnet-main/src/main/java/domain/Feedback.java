package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/3/13
 * Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "feedback")
public class Feedback implements Serializable{
    @Id @GeneratedValue
    @Column(name = "feedback_id")
    private Integer feedbackId;
    @Column(name = "feedback_time")
    private Date feedbackTime;
    @Lob
    @Column(name = "feedback_data")
    private byte[] feedbackData;
    @ManyToOne(targetEntity = Report.class)
    @JoinTable(name = "report_feedback",
            joinColumns = {@JoinColumn(name = "feedback_id")},
            inverseJoinColumns = {@JoinColumn(name = "report_id")})
    private Report report;

    @ManyToOne(targetEntity = User.class)
    @JoinTable(name = "user_feedback",
            joinColumns = {@JoinColumn(name = "feedback_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private User user;

    public int getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public Date getFeedbackTime() {
        return feedbackTime;
    }

    public void setFeedbackTime(Date feedbackTime) {
        this.feedbackTime = feedbackTime;
    }

    public byte[] getFeedbackData() {
        return feedbackData;
    }

    public void setFeedbackData(byte[] feedbackData) {
        this.feedbackData = feedbackData;
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
