package domain;

import javax.persistence.*;
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
public class Feedback {
    @Id @GeneratedValue
    @Column(name = "feedback_id")
    private int feedbackId;
    @Column(name = "feedback_time")
    private Date feedbackTime;
    @Lob
    @Column(name = "feedback_data")
    private Byte[] feedbackData;
    @ManyToOne(targetEntity = Report.class)
    private Report report;
    @ManyToOne(targetEntity = User.class)
    private User user;

}
