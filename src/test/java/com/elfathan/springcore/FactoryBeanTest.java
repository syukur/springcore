package com.elfathan.springcore;


import com.elfathan.springcore.client.PaymentGatewayClient;
import com.elfathan.springcore.configuration.FactoryBeanConfiguration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class FactoryBeanTest {

    ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(FactoryBeanConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testFactoryBean() {
        PaymentGatewayClient gatewayClient = applicationContext.getBean(PaymentGatewayClient.class);

        Assertions.assertNotNull(gatewayClient);
        Assertions.assertSame("https://testing.com", gatewayClient.getUrl());
        Assertions.assertSame("public-key", gatewayClient.getPublicKey());
        Assertions.assertSame("private-key", gatewayClient.getPrivateKey());
    }
}
