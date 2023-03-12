package com.elfathan.springcore.data;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Server1 {

    @PostConstruct
    public void start(){
      log.info("Start Server 1");
    }

    @PreDestroy
    public void stop(){
        log.info("Stop Server 1");
    }
}
