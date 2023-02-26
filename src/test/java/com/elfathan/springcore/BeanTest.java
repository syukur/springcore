package com.elfathan.springcore;

import com.elfathan.springcore.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class BeanTest {

    @Test
    void testCreateBean() {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext( BeanConfiguration.class );

        Assertions.assertNotNull( applicationContext );

    }

    @Test
    void testGetBean(){
        ApplicationContext applicationContext =  new AnnotationConfigApplicationContext( BeanConfiguration.class );

        Foo bean1 = applicationContext.getBean(Foo.class);
        Foo bean2 = applicationContext.getBean(Foo.class);
        bean2.setName("Syukur");

        log.info("bean2 name: {}", bean2.getName() );
        log.info("bean1 name: {}", bean1.getName() );

        Assertions.assertEquals(bean1,bean2);
    }

    @Test
    void testDuplicateBean(){
        ApplicationContext applicationContext =  new AnnotationConfigApplicationContext( BeanConfiguration.class );

        Foo bean = applicationContext.getBean("foo", Foo.class);
        Foo bean1 = applicationContext.getBean("foo_satu", Foo.class);
        bean1.setName("Syukur");

        Foo bean2 = applicationContext.getBean("foo_satu", Foo.class);

        log.info("bean name: {}", bean.getName() );
        log.info("bean1 name: {}", bean1.getName() );
        log.info("bean2 name: {}", bean2.getName() );

        //Assertions.assertEquals(bean1,bean);
    }


    @Test
    void testPrimaryBean (){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext( BeanConfiguration.class );

        Foo bean1 = applicationContext.getBean(Foo.class);
        Foo bean2 = applicationContext.getBean("foo",Foo.class);
        Foo bean3 = applicationContext.getBean("foo_satu",Foo.class);

        Assertions.assertSame(bean1, bean2);
        Assertions.assertNotSame(bean2, bean3);

    }

}
