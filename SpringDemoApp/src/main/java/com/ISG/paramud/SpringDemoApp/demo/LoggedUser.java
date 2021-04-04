package com.ISG.paramud.SpringDemoApp.demo;

import org.springframework.stereotype.Component;

@Component
public class LoggedUser implements Logger {
    
    @Override
    public void log() {
        System.out.println("User is logged");
    }
}
