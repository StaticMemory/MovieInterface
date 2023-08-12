package core.MediaRequestPackage;

import com.fasterxml.jackson.databind.JsonNode;

public class ActorProfile {
    private String gender;
    private String name;
    private String knownForDepartment;
    private String portraying;
    private String ID;
    private String profilePath;
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getKnownForDepartment() {
        return knownForDepartment;
    }
    public void setKnownForDepartment(String knownForDepartment) {
        this.knownForDepartment = knownForDepartment;
    }
    public String getPortraying() {
        return portraying;
    }
    public void setPortraying(String portraying) {
        this.portraying = portraying;
    }
    public String getID() {
        return ID;
    }
    public void setID(String iD) {
        ID = iD;
    }
    public String getProfilePath() {
        return profilePath;
    }
    public void setProfilePath(String profilePath) {
        this.profilePath = profilePath;
    }
    public ActorProfile(JsonNode nd) {
        this.gender = nd.get("gender").toString();
        if(this.gender == "2") gender = "Male";
        else if(this.gender == "1") gender = "Female";
        this.name = nd.get("name").toString();
        this.knownForDepartment = nd.get("known_for_department").toString();
        this.portraying = nd.get("character").toString();
        this.ID = nd.get("id").toString();
        this.profilePath = nd.get("profile_path").toString();
    }
    
}
