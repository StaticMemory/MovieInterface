package core.database;

import java.util.List;

public class Episode {
    private String airDate;
    private int epNum;
    private String overview;
    private int id;
    private List<String> actorList;

    public List<String> getActorList() {
        return actorList;
    }
    public void setActorList(List<String> actorList) {
        this.actorList = actorList;
    }
    public String getAirDate() {
        return airDate;
    }
    public void setAirDate(String airDate) {
        this.airDate = airDate;
    }
    public int getEpNum() {
        return epNum;
    }
    public void setEpNum(int epNum) {
        this.epNum = epNum;
    }
    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
