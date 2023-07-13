package core.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Configuration
@PropertySource("classpath:keyHolder.properties")
@PropertySource(value = "classpath:keyHolder.properties", ignoreResourceNotFound = true)
public class keyHolder {
    @Value("${test.home}")
    private String test;

    public String getTest() {
        return test;
    }
    public keyHolder(){
    }
   
}
