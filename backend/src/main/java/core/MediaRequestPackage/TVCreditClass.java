package core.MediaRequestPackage;

import com.fasterxml.jackson.databind.JsonNode;

public class TVCreditClass {
    private String ID;
    private String originalLanguage;
    private String originalName;
    private String overview;
    private String posterPath;
    private String firstAirDate;
    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public String getOriginalLanguage() {
        return originalLanguage;
    }
    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }
    public String getOriginalName() {
        return originalName;
    }
    public void setOriginalName(String originalName) {
        this.originalName = originalName;
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
    public String getFirstAirDate() {
        return firstAirDate;
    }
    public void setFirstAirDate(String firstAirDate) {
        this.firstAirDate = firstAirDate;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCharacter() {
        return character;
    }
    public void setCharacter(String character) {
        this.character = character;
    }
    private String name;
    private String character;
    public TVCreditClass(JsonNode nd) {
        this.ID = nd.get("id").toString();
        this.originalLanguage =  nd.get("original_language").toString();
        this.originalName =  nd.get("original_name").toString();
        this.overview =  nd.get("overview").toString();
        this.posterPath =  nd.get("poster_path").toString();
        this.firstAirDate =  nd.get("first_air_date").toString();
        this.name =  nd.get("name").toString();
        this.character =  nd.get("character").toString();
    }
}
