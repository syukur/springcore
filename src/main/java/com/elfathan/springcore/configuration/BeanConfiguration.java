package com.elfathan.springcore.configuration;

import com.elfathan.springcore.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@Slf4j
public class BeanConfiguration {

    @Primary
    @Bean(name = "foo")
    Foo foo(){
        Foo foo = new Foo();
        log.info("Bean Foo Was Created.");
        return foo;
    }

    @Bean(name = "foo_satu")
    Foo foo1(){
        Foo foo = new Foo();
        log.info("Bean Foo1 Was Created.");
        return foo;
    }
}
