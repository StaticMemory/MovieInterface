package core.api;
public class APIRequestBuilder {
    private String apiKey;
    
    final String baseUrl = "https://api.themoviedb.org/3/";
    public APIRequestBuilder(String key){
        this.apiKey = key;
    }
    public APIRequestBuilder(){
        this.apiKey = "";
    }
    public String movieSearchByWordTitle(String title, String page){
        //TODO: Add multipage result support
        return baseUrl + "search/movie?query=" + title + "&include_adult=false&language=en-US&page="+String.valueOf(page);
        
    }
    public String movieSearchByID(String id){
        return baseUrl + "movie/" + id + "?language=en-US";
    }
    public String tvSearchByID(String id){
        return baseUrl + "tv/" + id + "?language=en-US";
    }
    public String tvSearchByWordTitle(String title, String page){
        return baseUrl  + "search/tv?query=" + title + "&include_adult=false&language=en-US&page="+String.valueOf(page);
    }
    public String actorBuilderByID(String ID){
        return baseUrl + "movie/"+ ID +"/credits";
    }
    public String MovieActorCreditByID(String ID){
        return baseUrl + "person/" + ID +"/movie_credits";
    }
    public String TVActorCreditByID(String ID){
        return baseUrl + "person/" + ID +"/tv_credits";
    }
    public String actorSearchByID(String ID){
        return baseUrl + "person/" + ID;
    }
    public String actorSearchByName(String ID){
        return baseUrl + "search/person?query=" + ID + "&include_adult=false&language=en-US&page=1";
    }
}
