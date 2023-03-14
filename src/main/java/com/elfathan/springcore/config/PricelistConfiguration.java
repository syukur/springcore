package com.elfathan.springcore.config;

import com.elfathan.springcore.repository.PricelistRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PricelistConfiguration {

    @Bean
    PricelistRepository normalPricelistRepository(){
        return new PricelistRepository();
    }

    @Bean
    PricelistRepository premiumPricelistRepository(){
        return new PricelistRepository();
    }
}
