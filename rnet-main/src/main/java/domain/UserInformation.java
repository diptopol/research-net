package domain;

import javax.persistence.*;
import java.io.Serializable;


/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 10/3/13
 * Time: 11:13 AM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "user_information")
public class UserInformation implements Serializable{

    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "address")
    private String address;
    @Column(name = "profession")
    private String profession;

    @Id
    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
