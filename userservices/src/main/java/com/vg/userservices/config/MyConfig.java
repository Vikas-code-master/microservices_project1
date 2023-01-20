package com.vg.userservices.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MyConfig {
    @Bean
    @LoadBalanced // this annotation is used for restTemplate to make api call by application name e.g. http://ratingservice instead of http://localhost:8082
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
