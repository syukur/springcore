package com.elfathan.springcore;

import com.elfathan.springcore.optionalcomponent.component.Bar;
import com.elfathan.springcore.optionalcomponent.component.Foo;
import com.elfathan.springcore.optionalcomponent.component.FooBar;
import com.elfathan.springcore.optionalcomponent.configuration.OptionalComponetConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestOptionalComponent {

    ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(OptionalComponetConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testOptionalComponent() {

        Foo foo = applicationContext.getBean(Foo.class);
        FooBar fooBar = applicationContext.getBean(FooBar.class);

        Assertions.assertNotNull(foo);
        Assertions.assertNotNull(fooBar.getFoo());
        Assertions.assertSame(foo, fooBar.getFoo());

        Assertions.assertNull(fooBar.getBar());

    }
}
