package com.elfathan.springcore.configuration;

import com.elfathan.springcore.data.Bar;
import com.elfathan.springcore.data.Foo;
import com.elfathan.springcore.data.FooBar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;

public class DITestConfiguration {

    @Bean(value = "foo_bean")
    Foo foo(){
        return new Foo();
    }

    @Bean(value = "foo_bean_satu")
    Foo foo1(){
        return new Foo();
    }

    @Bean(value = "bar_bean")
    Bar bar(){
        return new Bar();
    }

    @Bean(value = "foobar_bean")
    FooBar fooBar(@Qualifier("foo_bean_satu") Foo foo, Bar bar ){
        return new FooBar(foo, bar);
    }

}
