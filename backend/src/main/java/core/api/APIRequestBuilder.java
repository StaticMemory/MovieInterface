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
}
