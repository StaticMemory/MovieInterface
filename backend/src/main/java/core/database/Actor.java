package core.database;

import java.util.List;

public class Actor {
    private List<String> knownMovies;
    private String name;
    private int gender; 
    private int id;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getGender() {
        return gender;
    }
    public void setGender(int gender) {
        this.gender = gender;
    }
    public List<String> getKnownMovies() {
        return knownMovies;
    }
    public void setKnownMovies(List<String> knownMovies) {
        this.knownMovies = knownMovies;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
