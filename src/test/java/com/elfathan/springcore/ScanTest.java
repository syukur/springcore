package com.elfathan.springcore;

import com.elfathan.springcore.configuration.ScanConfiguration;
import com.elfathan.springcore.data.Bar;
import com.elfathan.springcore.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ScanTest {
    ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ScanConfiguration.class);
    }

    @Test
    void test() {
        Foo foo = applicationContext.getBean(Foo.class);
        Bar bar = applicationContext.getBean(Bar.class);

        Assertions.assertNotNull(foo);
        Assertions.assertNotNull(bar);
    }
}
