package com.elfathan.springcore.configuration;

import com.elfathan.springcore.config.BarConfiguration;
import com.elfathan.springcore.config.FooConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({FooConfiguration.class, BarConfiguration.class})
public class MainConfiguration {

}
