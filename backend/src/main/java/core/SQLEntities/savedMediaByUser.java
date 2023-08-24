package core.SQLEntities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class savedMediaByUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String user;
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getNameOfSet() {
        return nameOfSet;
    }
    public void setNameOfSet(String nameOfSet) {
        this.nameOfSet = nameOfSet;
    }
    public String getListOfMedia() {
        return listOfMedia;
    }
    public void setListOfMedia(String listOfMedia) {
        this.listOfMedia = listOfMedia;
    }
    private String nameOfSet;
    private String listOfMedia;
}
