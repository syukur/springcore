package com.elfathan.springcore;

import com.elfathan.springcore.configuration.OptionalConfiguration;
import com.elfathan.springcore.data.Foo;
import com.elfathan.springcore.data.FooBar;
import com.elfathan.springcore.data.computer.Computer;
import com.elfathan.springcore.data.computer.SoundCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Optional;

public class TestOptional {

    ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(OptionalConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testOptional() {
//        Optional<Computer> computer = Optional.of(new Computer());
//        computer.flatMap(Computer::getSoundCard).flatMap(SoundCard::getUsbPort).flatMap();

        String str =  "Syukur";
        String other ="other";
      Optional<String> optional = Optional.empty();
        //Optional<String> optional = Optional.of(str);

        System.out.println( optional.orElse(other) );
            
    }

    @Test
    void testOptionalBean() {
        Foo foo = applicationContext.getBean(Foo.class);
        FooBar fooBar = applicationContext.getBean(FooBar.class);

        Assertions.assertNull(fooBar.getBar());
        Assertions.assertNotNull(foo);
        Assertions.assertNotNull(fooBar.getFoo());
        Assertions.assertSame(fooBar.getFoo(), foo);
    }
}
