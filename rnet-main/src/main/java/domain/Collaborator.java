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
    @Column(name = "role")
    private String role;
    @Id
    @OneToOne
    @JoinColumn(name="research_id")
    private Research research;
    @Id
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;


}
