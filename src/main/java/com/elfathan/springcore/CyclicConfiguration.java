package com.elfathan.springcore;

import com.elfathan.springcore.data.cyclic.CyclicA;
import com.elfathan.springcore.data.cyclic.CyclicB;
import com.elfathan.springcore.data.cyclic.CyclicC;
import org.springframework.context.annotation.Bean;

public class CyclicConfiguration {

    @Bean
    CyclicA cyclicA(CyclicB cyclicB){
        return new CyclicA(cyclicB);
    }

    @Bean
    CyclicB cyclicB(CyclicC cyclicC){
        return new CyclicB(cyclicC);
    }

    @Bean
    CyclicC cyclicC(CyclicA cyclicA){
        return new CyclicC(cyclicA);
    }

}
