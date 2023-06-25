package core.database;
import java.util.List;
public class Movie {
    private String title;
    private String data;
    private int id;
    private String imageLink;
    private List<Integer> genreList;
    private String releaseData;

    Movie(String title){
        
    }


    public String getReleaseData() {
        return releaseData;
    }
    public void setReleaseData(String releaseData) {
        this.releaseData = releaseData;
    }
    public String getLanguage() {
        return language;
    }
    public void setLanguage(String language) {
        this.language = language;
    }
    private String language;
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public List<Integer> getGenreList() {
        return genreList;
    }
    public void setGenreList(List<Integer> genreList) {
        this.genreList = genreList;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setData(String data) {
        this.data = data;
    }
    public void setImageLink(String imageLink) {
        this.imageLink = imageLink;
    }
    public void setActorList(List<String> actorList) {
        this.actorList = actorList;
    }
    public String getTitle() {
        return title;
    }
    public String getData() {
        return data;
    }
    public String getImageLink() {
        return imageLink;
    }
    public List<String> getActorList() {
        return actorList;
    }
    private List<String> actorList;
}
