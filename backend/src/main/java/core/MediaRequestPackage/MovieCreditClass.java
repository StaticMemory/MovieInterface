package core.MediaRequestPackage;

import com.fasterxml.jackson.databind.JsonNode;

public class MovieCreditClass {
    private String backdropPath;
    private String id;
    private String originalLanguage;
    private String originalTitle;
    private String overview;
    private String posterPath;
    private String releaseDate;
    private String title;
    private String character;
    public String getBackdropPath() {
        return backdropPath;
    }
    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getOriginalLanguage() {
        return originalLanguage;
    }
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }
    public String getOriginalTitle() {
        return originalTitle;
    }
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public String getPosterPath() {
        return posterPath;
    }
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getCharacter() {
        return character;
    }
    public void setCharacter(String character) {
        this.character = character;
    }
    public MovieCreditClass(JsonNode nd) {
        this.backdropPath = nd.get("id").toString();
        this.id = nd.get("id").toString();
        this.originalLanguage = nd.get("original_language").toString();
        this.originalTitle = nd.get("original_title").toString();
        this.overview = nd.get("overview").toString();
        this.posterPath = nd.get("poster_path").toString();
        this.releaseDate = nd.get("release_date").toString();
        this.title = nd.get("title").toString();
        this.character = nd.get("character").toString();
    }

}
