package com.elfathan.springcore.configuration;

import com.elfathan.springcore.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Slf4j
@Configuration
public class ScopeConfig {

    @Bean
    @Lazy
    @Scope("prototype")
    //@Scope("singleton")
    public Foo foo(){
        log.info("Create New Foo");
        return new Foo();
    }

}
