package com.elfathan.springcore.config;

import com.elfathan.springcore.data.Bar;
import com.elfathan.springcore.data.Foo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleConfiguration {

    @Bean
    Foo foo1(){
        return new Foo();
    }

    @Bean
    Foo foo2(){
        return new Foo();
    }

    @Bean
    Bar bar1 (){
        return new Bar();
    }

    @Bean
    Bar bar2 (){
        return new Bar();
    }

}
