package com.elfathan.springcore;

import com.elfathan.springcore.data.Car;
import com.elfathan.springcore.processor.IdGeneratorBeanPostProcessor;
import com.elfathan.springcore.processor.PrefixGeneratorBeanPostProcessor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
public class OrderedTest {

    @Configuration
    @Import({
            Car.class,
            IdGeneratorBeanPostProcessor.class,
            PrefixGeneratorBeanPostProcessor.class
    })
    public static class TestConfiguration{

    }

    ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(TestConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testBeanPostProcessor() {
        Car car = applicationContext.getBean(Car.class);
        log.info("car.id: {}", car.getId());
    }
}
