package core.MediaRequestPackage;

import com.fasterxml.jackson.databind.JsonNode;

public class TVIDClass {
    private String id;
    private String inProduction;
    private String popularity;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getInProduction() {
        return inProduction;
    }
    public void setInProduction(String inProduction) {
        this.inProduction = inProduction;
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
    public String getFirstAirDate() {
        return firstAirDate;
    }
    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
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
    private String posterPath;
    private String OriginalTitle;
    private String overview;
    private String backdropPath;
    private String originalLanguage;
    private String firstAirDate;
    private String tagline;
    private String title;
    public TVIDClass(JsonNode nd){

    }
}
