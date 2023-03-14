package com.elfathan.springcore.service;

import com.elfathan.springcore.repository.PricelistRepository;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PricelistService {

    @Getter
    PricelistRepository normalPricelistRepository;

    @Getter
    PricelistRepository premiumPricelistRepository;

    public PricelistService( @Qualifier("normalPricelistRepository") PricelistRepository normalPricelistRepository,
                            @Qualifier("premiumPricelistRepository") PricelistRepository premiumPricelistRepository) {

        this.normalPricelistRepository = normalPricelistRepository;
        this.premiumPricelistRepository = premiumPricelistRepository;
    }
}
