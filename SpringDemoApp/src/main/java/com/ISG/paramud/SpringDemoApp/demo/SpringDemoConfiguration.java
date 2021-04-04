package com.ISG.paramud.SpringDemoApp.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringDemoConfiguration {

        @Value("${isLogged}")
        boolean isLogged;
        
        @Bean
        public Logger logger() {
            if(isLogged) {
                return new LoggedUser();
            } else {
                return new UnLoggedUser();
            }
        }
    }

