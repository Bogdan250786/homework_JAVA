package com.ISG.paramud.SpringDemoApp;

import com.ISG.paramud.SpringDemoApp.demo.SpringDemoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Import;

@Import(SpringDemoConfiguration.class )
@SpringBootApplication
public class SpringDemoApplication {
	
	private static ApplicationContext applicationContext;
	public static void main(String[] args) {
		
		applicationContext = SpringApplication.run(SpringDemoApplication.class, args);
		String[] allBeanNames = SpringDemoApplication.applicationContext.getBeanDefinitionNames();
		Object demoTopicComponent = SpringDemoApplication.applicationContext.getBean("demoTopicComponent");
		System.out.println(demoTopicComponent);
		for (String beanName : allBeanNames) {
			System.out.println(beanName);
		}
	}
}
