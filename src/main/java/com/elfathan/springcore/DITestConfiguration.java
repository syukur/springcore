package com.elfathan.springcore;

import com.elfathan.springcore.data.Bar;
import com.elfathan.springcore.data.Foo;
import com.elfathan.springcore.data.FooBar;
import org.springframework.context.annotation.Bean;

public class DITestConfiguration {

    @Bean(value = "foo_bean")
    Foo foo(){
        return new Foo();
    }

    @Bean(value = "bar_bean")
    Bar bar(){
        return new Bar();
    }

    @Bean(value = "foobar_bean")
    FooBar fooBar( Foo foo, Bar bar ){
        return new FooBar(foo, bar);
    }

}
