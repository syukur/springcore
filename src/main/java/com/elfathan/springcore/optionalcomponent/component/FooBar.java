package com.elfathan.springcore.optionalcomponent.component;

import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FooBar {

    @Getter
    private Foo foo;

    @Getter
    private Bar bar;

    public FooBar(Optional<Foo> foo, Optional<Bar> bar) {
        this.foo = foo.orElse(null);
        this.bar = bar.orElse(null);
    }
}
