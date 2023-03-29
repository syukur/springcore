package com.elfathan.springcore.application;

import com.elfathan.springcore.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class FooApplication {
    @Bean
    public Foo foo(){
        return new Foo();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(Foo.class, args);
        Foo foo = applicationContext.getBean(Foo.class);
        log.info("foo:{}", foo);
    }
}
