package core.SQLEntities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private int reviewType; // 0 = movie, 1 = tv series, 2 = tv episode
    private long authorID;
    private LocalDate localDate;
    private String reviewData;
    public String getReviewData() {
        return reviewData;
    }
    public void setReviewData(String reviewData) {
        this.reviewData = reviewData;
    }
    public String getAuthorName() {
        return authorName;
    }
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
    private String authorName;
    public LocalDate getLocalDate() {
        return localDate;
    }
    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }
    public long getId() {
        return id;
    }
    public long getAuthorID() {
        return authorID;
    }
    public Review() {
        this.localDate = LocalDate.now();
    }
    public void setId(long id) {
        this.id = id;
    }
    public int getReviewType() {
        return reviewType;
    }
    public void setReviewType(int reviewType) {
        this.reviewType = reviewType;
    }
    public long getIdOfMedia() {
        return idOfMedia;
    }
    public void setIdOfMedia(long idOfMedia) {
        this.idOfMedia = idOfMedia;
    }
    public String getNameOfMedia() {
        return nameOfMedia;
    }
    public void setNameOfMedia(String nameOfMedia) {
        this.nameOfMedia = nameOfMedia;
    }
    private float reviewVal;
    public void setAuthorID(long authorID) {
        this.authorID = authorID;
    }
    public float getReviewVal() {
        return reviewVal;
    }
    public void setReviewVal(float reviewVal) {
        this.reviewVal = reviewVal;
    }
    private long idOfMedia;
    private String nameOfMedia;
}
