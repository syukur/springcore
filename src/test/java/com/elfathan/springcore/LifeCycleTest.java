package com.elfathan.springcore;

import com.elfathan.springcore.configuration.LifeCycleConfiguration;
import com.elfathan.springcore.data.Connection;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class LifeCycleTest {
    ConfigurableApplicationContext applicationContext;

    @BeforeEach
    public void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(LifeCycleConfiguration.class);
        applicationContext.registerShutdownHook();
    }

//    @AfterEach
//    public void tearDown() {
//        applicationContext.close();
//    }

    @Test
    public void testLifeCycle(){
        Connection connection = applicationContext.getBean(Connection.class);
    }
}
