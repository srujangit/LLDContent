package dev.srujan.springfirstproject.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationConfiguration {
    /*
    First object that we want to be injectable is Rest template
     */

    @Bean
    public RestTemplate createRestTemplate(){
        return new RestTemplate();
    }
}
