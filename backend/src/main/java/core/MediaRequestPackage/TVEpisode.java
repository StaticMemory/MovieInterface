package core.MediaRequestPackage;

import com.fasterxml.jackson.databind.JsonNode;

public class TVEpisode {
    private String airDate;
    private String episodeNumber;
    private String name;
    private String overview;
    private String runtime;
    private String stillPath;
    public String getStillPath() {
        return stillPath;
    }
    public void setStillPath(String stillPath) {
        this.stillPath = stillPath;
    }
    public String getAirDate() {
        return airDate;
    }
    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }
    public String getEpisodeNumber() {
        return episodeNumber;
    }
    public void setEpisodeNumber(String episodeNumber) {
        this.episodeNumber = episodeNumber;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public String getRuntime() {
        return runtime;
    }
    public void setRuntime(String runtime) {
        this.runtime = runtime;
    }
    public TVEpisode(JsonNode nd){
        airDate= nd.get("air_date").asText();
        episodeNumber = nd.get("episode_number").asText(airDate);
        name = nd.get("name").asText();
        overview = nd.get("overview").asText();
        runtime = nd.get("runtime").asText();
        stillPath = nd.get("still_path").asText();
    }
}
