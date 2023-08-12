package core.MediaRequestPackage;

import com.fasterxml.jackson.databind.JsonNode;

public class MovieIDClass {
    private String id;
    private String popularity;
    private String posterPath;
    private String OriginalTitle;
    private String overview;
    private String backdropPath;
    private String originalLanguage;
    private String releaseDate;
    private String tagline;
    private String title;
    private String status;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPopularity() {
        return popularity;
    }
    public void setPopularity(String popularity) {
        this.popularity = popularity;
    }
    public String getPosterPath() {
        return posterPath;
    }
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
    public String getOriginalTitle() {
        return OriginalTitle;
    }
    public void setOriginalTitle(String originalTitle) {
        OriginalTitle = originalTitle;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public String getBackdropPath() {
        return backdropPath;
    }
    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }
    public String getOriginalLanguage() {
        return originalLanguage;
    }
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }
    public String getReleaseDate() {
        return releaseDate;
    }
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
    public String getTagline() {
        return tagline;
    }
    public void setTagline(String tagline) {
        this.tagline = tagline;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public MovieIDClass(JsonNode nd) {
        this.id = nd.get("id").toString();
        this.popularity = nd.get("popularity").toString();
        this.posterPath = nd.get("poster_path").toString();
        this.OriginalTitle = nd.get("original_title").toString().replace("\"", "");
        this.overview = nd.get("overview").toString();
        this.backdropPath = nd.get("backdrop_path").toString();
        this.originalLanguage = nd.get("original_language").toString();
        this.releaseDate = nd.get("release_date").toString();
        this.tagline = nd.get("tagline").toString();
        this.title = nd.get("title").toString();
        this.status = nd.get("status").toString();
    }
}
