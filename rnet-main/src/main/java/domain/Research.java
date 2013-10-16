package domain;

import org.apache.log4j.helpers.DateTimeDateFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/3/13
 * Time: 11:18 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "research")
public class Research implements Serializable {
    @Id @GeneratedValue
    @Column(name = "research_id")
    private Integer researchId;
    @Column(name = "research_title")
    private String researchTitle;
    @Column(name = "research_status")
    private String researchStatus;
    @Temporal(TemporalType.DATE)
    @Column(name = "starting_time")
    private Date startingTime;
    @Lob
    @Column(name = "research_data")
    private byte[] researchData;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "research_milestone",
            joinColumns = {@JoinColumn(name = "research_id")},
            inverseJoinColumns = {@JoinColumn(name = "milestone_id")})
    private List<Milestone> milestoneList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "research", fetch = FetchType.LAZY)
    private List<Collaborator> collaboratorList;

    public List<Milestone> getMilestoneList() {
        return milestoneList;
    }

    public void setMilestoneList(List<Milestone> milestoneList) {
        this.milestoneList = milestoneList;
    }

    public List<Collaborator> getCollaboratorList() {
        return collaboratorList;
    }

    public void setCollaboratorList(List<Collaborator> collaborator) {
        this.collaboratorList = collaborator;
    }

    public int getResearchId() {
        return researchId;
    }

    public void setResearchId(int researchId) {
        this.researchId = researchId;
    }

    public String getResearchTitle() {
        return researchTitle;
    }

    public void setResearchTitle(String researchTitle) {
        this.researchTitle = researchTitle;
    }

    public String getResearchStatus() {
        return researchStatus;
    }

    public void setResearchStatus(String researchStatus) {
        this.researchStatus = researchStatus;
    }

    public Date getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Date startingTime) {
        this.startingTime = startingTime;
    }

    public byte[] getResearchData() {
        return researchData;
    }

    public void setResearchData(byte[] researchData) {
        this.researchData = researchData;
    }
}
