package com.example.demo.designPattern.singleton;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class Config {

    @Bean
    @Scope("prototype")//이건 프로토 빼면 싱긆톤
    public SingleModel singleModel(){
        return new SingleModel();
    }
}
