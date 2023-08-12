package core.MediaRequestPackage;

import com.fasterxml.jackson.databind.JsonNode;

public class ActorIntro {
    public String name;
    public String id;
    public String profilePath;
    public ActorIntro(JsonNode nd){
        this.name = nd.get("name").toString();
        this.id = nd.get("id").toString();
        this.profilePath = nd.get("profile_path").toString();
    }
}
