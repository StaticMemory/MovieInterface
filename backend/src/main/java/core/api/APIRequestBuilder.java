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
    public String movieSearchByWordTitle(String title){
        //TODO: Add multipage result support
        return baseUrl + "search/movie?query=" + title + "&include_adult=false&language=en-US&page=1";
        
    }
    public String movieSearchByID(String id){
        return baseUrl + "movie/" + id + "?language=en-US";
    }
    public String tvSearchByID(String id){
        return baseUrl + "tv/" + id + "?language=en-US";
    }
    public String tvSearchByWordTitle(String title){
        return baseUrl  + "search/tv?query=" + title + "&include_adult=false&language=en-US&page=1";
    }
}
