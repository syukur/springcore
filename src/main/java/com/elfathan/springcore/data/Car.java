package com.elfathan.springcore.data;

import com.elfathan.springcore.aware.IdAware;
import lombok.Getter;
import org.springframework.stereotype.Component;


@Component
public class Car implements IdAware {

    private String id;

    @Override
    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }


}
