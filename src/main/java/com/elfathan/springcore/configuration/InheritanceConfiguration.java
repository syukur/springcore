package com.elfathan.springcore.configuration;

import com.elfathan.springcore.service.MerchantServiceImpl;
import org.springframework.context.annotation.Import;

@Import({MerchantServiceImpl.class})
public class InheritanceConfiguration {
}
