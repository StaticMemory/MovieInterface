package core.MediaRequestPackage;

import com.fasterxml.jackson.databind.JsonNode;

public class TVSeriesOverview {
    private String airDate;
    private String episodeCount;
    private String name;
    private String overview;
    private String posterPath;
    private String seasonNumber;
    private String voteAverage;
    public TVSeriesOverview(JsonNode nd){
        airDate = nd.get("air_date").asText();
        episodeCount = nd.get("episode_count").asText();
        name = nd.get("name").asText();
        overview = nd.get("overview").asText();
        posterPath = nd.get("poster_path").asText();
        seasonNumber = nd.get("season_number").asText();
        voteAverage = nd.get("vote_average").asText();
    }
    public String getAirDate() {
        return airDate;
    }
    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }
    public String getEpisodeCount() {
        return episodeCount;
    }
    public void setEpisodeCount(String episodeCount) {
        this.episodeCount = episodeCount;
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
    public String getPosterPath() {
        return posterPath;
    }
    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }
    public String getSeasonNumber() {
        return seasonNumber;
    }
    public void setSeason_number(String seasonNumber) {
        this.seasonNumber = seasonNumber;
    }
    public String getVoteAverage() {
        return voteAverage;
    }
    public void setVote_average(String voteAverage) {
        this.voteAverage = voteAverage;
    }
}
