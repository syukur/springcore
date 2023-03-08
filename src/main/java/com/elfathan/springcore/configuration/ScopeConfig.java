package com.elfathan.springcore.configuration;

import com.elfathan.springcore.data.Bar;
import com.elfathan.springcore.data.Foo;
import com.elfathan.springcore.scope.DoubletonScope;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
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

    @Bean
    public CustomScopeConfigurer customScopeConfigurer(){
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        configurer.addScope("doubleton", new DoubletonScope());
        return configurer;
    }

    @Bean
    @Scope("doubleton")
    public Bar bar(){
        log.info("Create new Bar");
        return new Bar();
    }
}
