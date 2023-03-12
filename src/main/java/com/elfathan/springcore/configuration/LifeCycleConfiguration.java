package com.elfathan.springcore.configuration;

import com.elfathan.springcore.data.Connection;
import com.elfathan.springcore.data.Server;
import com.elfathan.springcore.data.Server1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class LifeCycleConfiguration {
    @Bean
    @Lazy
    public Connection connection(){
        return new Connection();
    }

    @Bean( initMethod = "start", destroyMethod = "stop" )
    @Lazy
    public Server server(){
        return new Server();
    }
    @Bean
    @Lazy
    public Server1 server1(){
        return new Server1();
    }
}
