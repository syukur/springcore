package com.elfathan.springcore;

import com.elfathan.springcore.data.cyclic.CyclicA;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestCyclic {

    ApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(CyclicConfiguration.class);
    }

    @Test
    void testCyclic() {
        applicationContext.getBean(CyclicA.class);
    }
}
