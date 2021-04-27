package com.ISG.paramud.SpringDemoApp.demo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoServicesAspect {
    
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @AfterReturning(pointcut = "execution (* com.ISG.paramud.SpringDemoApp.demo.DemoTopicService.*(..))",
            returning = "returnObject")
    public void afterReturnTopicService(JoinPoint joinPoint, Object returnObject) {
        logger.info("{}Method of DemoTopicService was executed{}", joinPoint, returnObject);
    }
    
}
