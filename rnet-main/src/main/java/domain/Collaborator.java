package domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/3/13
 * Time: 11:17 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "collaborator")
public class Collaborator implements Serializable{
    @Id @GeneratedValue
    @Column(name = "collaborator_id")
    private Integer collaboratorId;
    @Column(name = "role")
    private String role;

    @ManyToOne
    @JoinColumn(name="research_id")
    private Research research;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public int getCollaboratorId() {
        return collaboratorId;
    }

    public void setCollaboratorId(int collaboratorId) {
        this.collaboratorId = collaboratorId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Research getResearch() {
        return research;
    }

    public void setResearch(Research research) {
        this.research = research;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
