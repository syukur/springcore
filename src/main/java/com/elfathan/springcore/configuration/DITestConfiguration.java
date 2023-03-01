package com.elfathan.springcore.configuration;

import com.elfathan.springcore.data.Bar;
import com.elfathan.springcore.data.Foo;
import com.elfathan.springcore.data.FooBar;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DITestConfiguration {

    @Bean(value = "foo_bean")
    public Foo foo(){
        return new Foo();
    }

    @Bean(value = "foo_bean_satu")
    public Foo foo1(){
        return new Foo();
    }

    @Bean(value = "bar_bean")
    public Bar bar(){
        return new Bar();
    }

    @Bean(value = "foobar_bean")
    public FooBar fooBar(@Qualifier("foo_bean_satu") Foo foo, Bar bar ){
        return new FooBar(foo, bar);
    }

}
