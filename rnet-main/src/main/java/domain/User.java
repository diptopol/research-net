package domain;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 9/30/13
 * Time: 12:21 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "user")
public class User {
    @Id @GeneratedValue
    @Column(name = "user_id")
    private int userId;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
