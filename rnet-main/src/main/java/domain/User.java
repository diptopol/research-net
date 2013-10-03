package domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 9/30/13
 * Time: 12:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "user")
public class User implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id")
    private int userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "user")
    private UserInformation userInformation;

    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "user")
    private Collaborator collaborator;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Report> reportList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    private List<Feedback> feedbackList;

    public List<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public void setFeedbackList(List<Feedback> feedbackList) {
        this.feedbackList = feedbackList;
    }

    public List<Report> getReportList() {
        return reportList;
    }

    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }

    public UserInformation getUserInformation() {
        return userInformation;
    }

    public void setUserInformation(UserInformation userInformation) {
        this.userInformation = userInformation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
