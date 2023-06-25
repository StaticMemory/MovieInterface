package core.database;

import java.util.List;

public class Season {
    private List<Episode> episodeList;
    private String seasonImage;
    public String getSeasonImage() {
        return seasonImage;
    }

    public void setSeasonImage(String seasonImage) {
        this.seasonImage = seasonImage;
    }

    public List<Episode> getEpisodeList() {
        return episodeList;
    }

    public void setEpisodeList(List<Episode> episodeList) {
        this.episodeList = episodeList;
    }
    }
