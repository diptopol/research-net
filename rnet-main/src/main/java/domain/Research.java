package domain;

import javax.persistence.*;
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
public class Research {
    @Id @GeneratedValue
    @Column(name = "research_id")
    private int researchId;
    @Column(name = "research_title")
    private String researchTitle;
    @Column(name = "research_status")
    private String researchStatus;
    @Column(name = "starting_time")
    private Date startingTime;
    @Lob
    @Column(name = "research_data")
    private byte[] researchData;
    @OneToMany(fetch = FetchType.LAZY,mappedBy = "research")
    private List<Milestone> milestoneList;
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "research")
    private Collaborator collaborator;

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
