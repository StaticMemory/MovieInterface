package core.SQLEntities;


import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "username")
    private String username;
    private LocalDate accountCreated;
    private String image;
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public User() {
        this.accountCreated = LocalDate.now();
    }
    public LocalDate getAccountCreated() {
        return accountCreated;
    }
    public void setAccountCreated(LocalDate accountCreated) {
        this.accountCreated = accountCreated;
    }
    public String getUsername() {
        return username;
    }
    public User(String username, long id) {
        this.username = username;
        this.id = id;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
}
