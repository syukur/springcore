package com.elfathan.springcore.processor;

import com.elfathan.springcore.aware.IdAware;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;

import java.util.UUID;

@Slf4j
public class PrefixGeneratorBeanPostProcessor implements BeanPostProcessor, Ordered {
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        log.info("execute postProcessAfterInitialization");

        if( bean instanceof IdAware){
            log.info("bean is type of IdWare");
            IdAware idAware = (IdAware) bean;
            idAware.setId("PZN-" + idAware.getId());
        }

        return bean;
        //return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
