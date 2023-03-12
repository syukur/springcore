package com.elfathan.springcore;

import com.elfathan.springcore.configuration.ComponenConfiguration;
import com.elfathan.springcore.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {

    ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ComponenConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void test() {
        ProductService productService1 = applicationContext.getBean(ProductService.class);
        ProductService productService2 = applicationContext.getBean("productService",ProductService.class);

        Assertions.assertNotNull(productService1);
        Assertions.assertSame(productService1, productService2);
    }
}
