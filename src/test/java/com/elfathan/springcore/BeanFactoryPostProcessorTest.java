package com.elfathan.springcore;

import com.elfathan.springcore.data.Foo;
import com.elfathan.springcore.processor.FooBeanFactoryPostProcessor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class BeanFactoryPostProcessorTest {

    @Configuration
    @Import({FooBeanFactoryPostProcessor.class})
    public static class BeanFactoryPostProcessorConfiguration{

    }

    ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(BeanFactoryPostProcessorConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testing() {
        Foo foo = applicationContext.getBean(Foo.class);
        Assertions.assertNotNull(foo);
    }
}
