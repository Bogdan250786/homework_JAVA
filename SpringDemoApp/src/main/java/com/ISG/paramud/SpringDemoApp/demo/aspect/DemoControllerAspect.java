package com.ISG.paramud.SpringDemoApp.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoControllerAspect {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @After("execution (* com.ISG.paramud.SpringDemoApp.demo.DemoTopicService.*(..))")
    public void afterAppController() {
        logger.info("Method of DemoAppController was executed");
    }
}


