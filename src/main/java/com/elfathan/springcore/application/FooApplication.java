package com.elfathan.springcore.application;

import com.elfathan.springcore.data.Bar;
import com.elfathan.springcore.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@Slf4j
public class FooApplication {

    @Bean Bar bar(){
        return new Bar();
    }
    @Bean
    public Foo foo(Bar bar){
        return new Foo();
    }

//    public static void main(String[] args) {
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(FooApplication.class, args);
//        Foo foo = applicationContext.getBean(Foo.class);
//        log.info("foo:{}", foo);
//    }

    /**
     * Customizing Spring Application
     * */
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(FooApplication.class);
        springApplication.setBannerMode(Banner.Mode.OFF);

        ConfigurableApplicationContext applicationContext = springApplication.run(args);
        Foo foo = applicationContext.getBean(Foo.class);
        log.info("foo:{}", foo);

    }
}
