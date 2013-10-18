package domain;

import javax.persistence.*;
import java.io.Serializable;
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
public class Milestone implements Serializable{
    @Id @GeneratedValue
    @Column(name = "milestone_id")
    private Integer milestoneId;
    @Column(name = "description")
    private String description;
    @Column(name = "milestone_status")
    private String milestoneStatus;
    @Column(name = "sequence")
    private Integer sequence;
    @ManyToOne(targetEntity = Research.class)
    @JoinTable(name = "research_milestone",
            joinColumns = {@JoinColumn(name = "milestone_id", insertable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "research_id", insertable = false, updatable = false)})
    private Research research;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "milestone_report",
            joinColumns = {@JoinColumn(name = "milestone_id")},
            inverseJoinColumns = {@JoinColumn(name = "report_id")})
    private List<Report> reportList;

    public Research getResearch() {
        return research;
    }

    public void setResearch(Research research) {
        this.research = research;
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getMilestoneId() {
        return milestoneId;
    }

    public void setMilestoneId(Integer milestoneId) {
        this.milestoneId = milestoneId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMilestoneStatus() {
        return milestoneStatus;
    }

    public void setMilestoneStatus(String milestoneStatus) {
        this.milestoneStatus = milestoneStatus;
    }

    public List<Report> getReportList() {
        return reportList;
    }

    public void setReportList(List<Report> reportList) {
        this.reportList = reportList;
    }

}
