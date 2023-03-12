package com.elfathan.springcore;

import com.elfathan.springcore.configuration.MainConfiguration;
import com.elfathan.springcore.data.Bar;
import com.elfathan.springcore.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigImportTest {

    ApplicationContext applicationContext;

    @BeforeEach
    void setup(){
        applicationContext = new AnnotationConfigApplicationContext(MainConfiguration.class);
    }

    @Test
    void test(){
        Foo foo = applicationContext.getBean(Foo.class);
        Bar bar = applicationContext.getBean(Bar.class);

        Assertions.assertNotNull(foo);
        Assertions.assertNotNull(bar);
    }

}
