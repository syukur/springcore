package com.elfathan.springcore;

import com.elfathan.springcore.configuration.ComponenConfiguration;
import com.elfathan.springcore.repository.CategoryRepository;
import com.elfathan.springcore.repository.CustomerRepository;
import com.elfathan.springcore.repository.PricelistRepository;
import com.elfathan.springcore.repository.ProductRepository;
import com.elfathan.springcore.service.CategoryService;
import com.elfathan.springcore.service.CustomerService;
import com.elfathan.springcore.service.PricelistService;
import com.elfathan.springcore.service.ProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ComponentTest {

    ConfigurableApplicationContext applicationContext;

    @BeforeEach
    void setUp() {
        applicationContext = new AnnotationConfigApplicationContext(ComponenConfiguration.class);
        applicationContext.registerShutdownHook();
    }

    @Test
    void testService() {
        ProductService productService1 = applicationContext.getBean(ProductService.class);
        ProductService productService2 = applicationContext.getBean("productService",ProductService.class);

        Assertions.assertNotNull(productService1);
        Assertions.assertSame(productService1, productService2);
    }

    @Test
    void testDependencyInjectionConstructor(){
        ProductService productService = applicationContext.getBean(ProductService.class);
        ProductRepository productRepository = applicationContext.getBean(ProductRepository.class);

        Assertions.assertSame(productRepository, productService.getProductRepository());
    }

    @Test
    void testDependencyInjectionSetter(){
        CategoryService categoryService = applicationContext.getBean(CategoryService.class);
        CategoryRepository categoryRepository = applicationContext.getBean(CategoryRepository.class);

        Assertions.assertSame(categoryService.getCategoryRepository(), categoryRepository);
    }

    @Test
    void testDependencyInjectionFieldBase(){
        CustomerService customerService = applicationContext.getBean(CustomerService.class);
        CustomerRepository customerRepository = applicationContext.getBean(CustomerRepository.class);

        Assertions.assertSame(customerService.getCustomerRepository(), customerRepository);
    }

    @Test
    void testQualifier(){
        PricelistService pricelistService = applicationContext.getBean(PricelistService.class);
        PricelistRepository normalPricelistRepository = applicationContext.getBean("normalPricelistRepository", PricelistRepository.class);
        PricelistRepository premiumPricelistRepository = applicationContext.getBean("premiumPricelistRepository", PricelistRepository.class);

        Assertions.assertSame(pricelistService.getNormalPricelistRepository(), normalPricelistRepository);
        Assertions.assertSame(pricelistService.getPremiumPricelistRepository(), premiumPricelistRepository);
    }
}
