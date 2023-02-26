package com.elfathan.springcore;

import com.elfathan.springcore.data.Bar;
import com.elfathan.springcore.data.Foo;
import com.elfathan.springcore.data.FooBar;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class TestDependencyInjection {

    ApplicationContext applicationContext;
    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(DITestConfiguration.class);
    }


    /** Create Bean dengan cara,
     * otomatis menggunakan metode DI dari spring framework
     * */
    @Test
    void testWithDependencyInjection() {
        Foo fooBean = applicationContext.getBean("foo_bean", Foo.class);
        Bar barBean = applicationContext.getBean("bar_bean", Bar.class);

        FooBar fooBarBean = applicationContext.getBean("foobar_bean", FooBar.class);

        Assertions.assertSame(fooBean, fooBarBean.getFoo());
        Assertions.assertSame(barBean, fooBarBean.getBar());

    }

    @Test
    void testWithoutDependencyInjection() {
        /** Dengan cara manual,
         * semua dependency di instant manual
         * dan di masukan sebagai paramater
         * */

        Foo foo = new Foo();
        Bar bar = new Bar();

        FooBar fooBar = new FooBar(foo, bar);

        Assertions.assertSame(foo, fooBar.getFoo());
        Assertions.assertSame(bar, fooBar.getBar());
    }
}
