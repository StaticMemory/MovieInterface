package core.api;

import java.util.ArrayList;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import core.MediaRequestPackage.MovieSubfolderPackage;
import core.MediaRequestPackage.TVSeriesSubfolder;
@RestController
@EnableAutoConfiguration
public class APIHead {
    @RequestMapping(value="/movieBySearch")
    public ArrayList<MovieSubfolderPackage> returnBasicMovie (@RequestHeader("title") String title, @RequestHeader("page") String page){
        TMDBInteractor interactor = new TMDBInteractor();
        return interactor.requestMovieByString(title, page);
        
    }
    @RequestMapping(value="/TVSeriesBySearch")
    public ArrayList<TVSeriesSubfolder> returnBasicTVSeries(@RequestHeader("title") String title, @RequestHeader("page") String page){
        TMDBInteractor interactor = new TMDBInteractor();
        
        return interactor.requestTVSeriesByString(title, page);
    }
}
