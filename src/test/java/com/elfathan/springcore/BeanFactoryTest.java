package com.elfathan.springcore;

import com.elfathan.springcore.configuration.ScanConfiguration;
import com.elfathan.springcore.data.Bar;
import com.elfathan.springcore.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
public class BeanFactoryTest {
    
    ConfigurableApplicationContext applicationContext;
    
    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ScanConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testBeanFactory() {
        ObjectProvider<Foo> fooObjectProvider = applicationContext.getBeanProvider(Foo.class);
        List<Foo> fooList = fooObjectProvider.stream().collect(Collectors.toList());
        fooList.forEach( value -> {
            log.info("item: " + value);
        });

        Map<String, Bar> barMap = applicationContext.getBeansOfType(Bar.class);
        barMap.forEach((key, value) -> {
            log.info("name: {}, bean: {}", key, value);
        });

    }
}
