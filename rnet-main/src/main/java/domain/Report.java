package domain;

import javax.persistence.*;
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
public class Report {
    @Id @GeneratedValue
    @Column(name = "report_id")
    private int reportId;
    @Column(name = "report_status")
    private String reportStatus;
    @Column(name = "reporting_time")
    private Date reportingTime;
    @Lob
    @Column(name = "report_data")
    private byte[] reportData;
    @ManyToOne(targetEntity = User.class)
    private User user;
    @ManyToOne(targetEntity = Milestone.class)
    private Milestone milestone;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "report")
    private List<Feedback> feedbackList;
}
