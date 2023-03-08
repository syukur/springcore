package com.elfathan.springcore.configuration;

import com.elfathan.springcore.data.Connection;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LifeCycleConfiguration {
    @Bean
    public Connection connection(){
        return new Connection();
    }
}
