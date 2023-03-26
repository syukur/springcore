package com.elfathan.springcore;

import com.elfathan.springcore.service.AuthService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
public class AwareTest {

    @Configuration
    @Import({
            AuthService.class,
    })
    public static class AwareConfiguration{

    }

    ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(AwareConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testAware() {
        AuthService authService = applicationContext.getBean(AuthService.class);
        log.info("bean_name: {}", authService.getBeanName());

        Assertions.assertSame("com.elfathan.springcore.service.AuthService", authService.getBeanName());
        Assertions.assertSame(applicationContext, authService.getApplicationContext());
    }
}
