package domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/3/13
 * Time: 11:15 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "milestone")
public class Milestone {
    @Id @GeneratedValue
    @Column(name = "milestone_id")
    private int milestoneId;
    @Column(name = "description")
    private String description;
    @Column(name = "milestone_status")
    private String milestoneStatus;
    @ManyToOne(targetEntity = Research.class)
    private Research research;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "milestone")
    private List<Report> reportList;
}
