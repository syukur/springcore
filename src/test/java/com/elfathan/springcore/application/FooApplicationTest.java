package com.elfathan.springcore.application;

import com.elfathan.springcore.data.Foo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = FooApplication.class)
@Slf4j
class FooApplicationTest {

    @Autowired
    Foo foo;

    @Test
    void foo() {
        Assertions.assertNotNull(foo);
        log.info("foo: {}", foo);
    }
}