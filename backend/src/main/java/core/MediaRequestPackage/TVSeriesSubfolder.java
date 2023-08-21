package core.MediaRequestPackage;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonNode;
public class TVSeriesSubfolder {
    boolean adult;
    String backdrop_path;
    List<Integer> genre_ids;
    int id;
    String origin_country;
    String original_language;
    String original_name;
    String overview;
    double popularity;
    String poster_path;
    String first_air_date;
    String name;
    public boolean isAdult() {
        return adult;
    }
    public void setAdult(boolean adult) {
        this.adult = adult;
    }
    public String getBackdrop_path() {
        return backdrop_path;
    }
    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }
    public List<Integer> getGenre_ids() {
        return genre_ids;
    }
    public void setGenre_ids(List<Integer> genre_ids) {
        this.genre_ids = genre_ids;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getOrigin_country() {
        return origin_country;
    }
    public void setOrigin_country(String origin_country) {
        this.origin_country = origin_country;
    }
    public String getOriginal_language() {
        return original_language;
    }
    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }
    public String getOriginal_name() {
        return original_name;
    }
    public void setOriginal_name(String original_name) {
        this.original_name = original_name;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public double getPopularity() {
        return popularity;
    }
    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }
    public String getPoster_path() {
        return poster_path;
    }
    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }
    public String getFirst_air_date() {
        return first_air_date;
    }
    public void setFirst_air_date(String first_air_date) {
        this.first_air_date = first_air_date;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
     public TVSeriesSubfolder(JsonNode nd){
        this.adult = nd.get("adult").asBoolean();
        this.backdrop_path = nd.get("backdrop_path").asText();
        this.id = nd.get("id").asInt();
        this.origin_country = nd.get("origin_country").asText();
        this.original_language = nd.get("original_language").asText();
        this.original_name = nd.get("original_name").asText();
        this.overview = nd.get("overview").asText();
        this.popularity = nd.get("popularity").asDouble();
        this.poster_path = nd.get("poster_path").asText();
        this.first_air_date = nd.get("first_air_date").asText();
        this.name = nd.get("name").asText();
    }
}
