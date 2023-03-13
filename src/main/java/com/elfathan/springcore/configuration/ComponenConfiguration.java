package com.elfathan.springcore.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = {"com.elfathan.springcore.service","com.elfathan.springcore.repository"})
public class ComponenConfiguration {
}
