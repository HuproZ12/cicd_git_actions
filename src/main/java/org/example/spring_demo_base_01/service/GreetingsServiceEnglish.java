package org.example.spring_demo_base_01.service;

import org.springframework.stereotype.Service;

@Service("greetings")
public class GreetingsServiceEnglish implements GreetingsService{
    @Override
    public String sayHello() {
        return "Hello everyone !!";
    }
}
