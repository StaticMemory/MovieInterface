package core.MediaRequestPackage;

import java.util.List;

import com.fasterxml.jackson.databind.JsonNode;

public class MovieSubfolderPackage {
    boolean adult = false;
    String backdrop_path;
    List<Integer> genre_ids;
    int id;
    String original_language;
    String original_title;
    String overview;
    double popularity;
    String poster_path;
    String release_date;
    String title;
    String video;
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
    public String getOriginal_language() {
        return original_language;
    }
    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }
    public String getOriginal_title() {
        return original_title;
    }
    public void setOriginal_title(String original_title) {
        this.original_title = original_title;
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
    public String getRelease_date() {
        return release_date;
    }
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getVideo() {
        return video;
    }
    public void setVideo(String video) {
        this.video = video;
    }
    public double getVote_average() {
        return vote_average;
    }
    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }
    public int getFloat_count() {
        return float_count;
    }
    public void setFloat_count(int float_count) {
        this.float_count = float_count;
    }
    double vote_average;
    int float_count;
    public MovieSubfolderPackage(JsonNode nd){
        this.adult = nd.get("adult").asBoolean();
        this.backdrop_path = nd.get("backdrop_path").asText();
        this.id = nd.get("id").asInt();
        this.original_language = nd.get("original_language").asText();
        this.original_title = nd.get("original_title").asText();
        this.overview = nd.get("overview").asText();
        this.popularity = nd.get("popularity").asDouble();
        this.poster_path = nd.get("poster_path").asText();
        this.release_date = nd.get("release_date").asText();
        this.title = nd.get("title").asText();
        this.video = nd.get("video").asText();
    }
}
