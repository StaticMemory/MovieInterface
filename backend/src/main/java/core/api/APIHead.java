package core.api;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class APIHead {
    @RequestMapping(value="/")
    public String returnTest (){
        TMDBInteractor interactor = new TMDBInteractor();
        interactor.requestMovieByString("Dark");
        return "1";
    }
}
