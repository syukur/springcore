package com.elfathan.springcore.configuration;

import com.elfathan.springcore.data.Bar;
import com.elfathan.springcore.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;

@Slf4j
@Configuration
public class DepensOnConfiguration {

    @Lazy
    @Bean(value = "foo")
    @DependsOn("bar")
    Foo foo(){
        log.info("Create New Foo");
        return new Foo();
    }

    @Bean(value = "bar")
    Bar bar(){
        log.info("Create New Bar");
        return new Bar();
    }

}
