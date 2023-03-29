package com.elfathan.springcore.listener;

import com.elfathan.springcore.event.LoginSuccessEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserListener {
    @EventListener(classes = LoginSuccessEvent.class)
    public void onLoginSuccessEvent(LoginSuccessEvent event){
        log.info("Found login success (using anotation) user:{}", event.getUser());
    }

    @EventListener(classes = LoginSuccessEvent.class)
    public void onLoginSuccessEvent1(LoginSuccessEvent event){
        log.info("Found login success (using anotation 1) user:{}", event.getUser());
    }
}
