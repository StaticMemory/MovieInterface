package core.MediaRequestPackage;

import com.fasterxml.jackson.databind.JsonNode;

public class SpecificActor {
    private String gender;
    private String name;
    private String knownForDepartment;
    private String ID;
    private String profilePath;
    private String biography;
    private String birthday;
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public SpecificActor(JsonNode nd) {
        this.gender = nd.get("gender").toString();
        this.name = nd.get("name").toString();;
        this.knownForDepartment = nd.get("known_for_department").toString();;
        this.ID = nd.get("id").toString();
        this.profilePath = nd.get("profile_path").toString();;
        this.biography = nd.get("biography").toString();;
        this.birthday = nd.get("birthday").toString();;
        this.placeOfBirth = nd.get("place_of_birth").toString();;
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
    public String getBiography() {
        return biography;
    }
    public void setBiography(String biography) {
        this.biography = biography;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getPlaceOfBirth() {
        return placeOfBirth;
    }
    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }
    private String placeOfBirth;
    

}
