package com.elfathan.springcore;

import com.elfathan.springcore.data.Bar;
import com.elfathan.springcore.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.DependsOn;

@Slf4j
public class DepensOnConfiguration {

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
