package com.elfathan.springcore;

import com.elfathan.springcore.listener.LoginAgainSuccessListener;
import com.elfathan.springcore.listener.LoginSuccessListener;
import com.elfathan.springcore.listener.UserListener;
import com.elfathan.springcore.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

public class EventListenerTest {

    @Import({
            UserService.class,
            LoginSuccessListener.class,
            LoginAgainSuccessListener.class,
            UserListener.class
    })
    @Configuration
    public static class EventListenerConfiguration{

    }

    ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(EventListenerConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testEventListener() {
        UserService userService = applicationContext.getBean(UserService.class);
        userService.login("elfathan", "elfathan");
        userService.login("azka", "azka");
        //userService.login("azka", "azka");
    }
}
