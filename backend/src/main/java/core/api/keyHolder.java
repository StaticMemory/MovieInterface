package core.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:keyHolder.properties")
@PropertySource(value = "classpath:keyHolder.properties", ignoreResourceNotFound = true)
public class keyHolder {
    @Value("${test.home}")
    private String key;

    public String getKey() {
        return key;
    }
    public keyHolder(){
    }
   
}
