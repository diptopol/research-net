package domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/3/13
 * Time: 11:19 AM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "external_collaborator")
public class ExternalCollaborator implements Serializable{
    @Id
    @OneToOne
    @JoinColumn(name="research_id")
    private Research research;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;

    public Research getResearch() {
        return research;
    }

    public void setResearch(Research research) {
        this.research = research;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
