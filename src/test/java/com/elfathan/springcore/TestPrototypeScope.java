package com.elfathan.springcore;

import com.elfathan.springcore.configuration.ScopeConfig;
import com.elfathan.springcore.data.Foo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestPrototypeScope {

    ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ScopeConfig.class);
    }

    @Test
    void testPrototypeScope() {
        Foo foo1 = applicationContext.getBean("foo", Foo.class);
        Foo foo2 = applicationContext.getBean("foo", Foo.class);
        Foo foo3 = applicationContext.getBean("foo", Foo.class);

        Assertions.assertNotSame(foo1, foo2);
        Assertions.assertNotSame(foo1, foo3);
        Assertions.assertNotSame(foo2, foo3);
    }
}
