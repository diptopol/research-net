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
    private Byte[] feedbackData;
    @ManyToOne(targetEntity = Report.class)
    private Report report;

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

    public Byte[] getFeedbackData() {
        return feedbackData;
    }

    public void setFeedbackData(Byte[] feedbackData) {
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

    @ManyToOne(targetEntity = User.class)
    private User user;

}
