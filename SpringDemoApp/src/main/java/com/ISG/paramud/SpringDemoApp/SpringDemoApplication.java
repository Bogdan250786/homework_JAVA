package com.ISG.paramud.SpringDemoApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * You need first to invite page /topic to load your topic list into a database
 */

@SpringBootApplication
public class SpringDemoApplication {
    
    private static ApplicationContext applicationContext;
    
    public static void main(String[] args) {
        
        applicationContext = SpringApplication.run(SpringDemoApplication.class, args);
        String[] allBeanNames = SpringDemoApplication.applicationContext.getBeanDefinitionNames();
        Object demoTopicService = SpringDemoApplication.applicationContext.getBean("demoTopicService");
        System.out.println(demoTopicService);
        for (String beanName : allBeanNames) {
            System.out.println(beanName);
        }
    }
}
