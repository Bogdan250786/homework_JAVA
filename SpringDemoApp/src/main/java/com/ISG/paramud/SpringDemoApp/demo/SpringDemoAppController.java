package com.ISG.paramud.SpringDemoApp.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SpringDemoAppController {
    
    @Autowired
    DemoTopicComponent demoTopicComponent;
    
    @Autowired
    Logger logger;
    
    @GetMapping("/topic")
    public List<Topic> getAllReservations() {
        logger.log();
        return demoTopicComponent.getDemoTopicList();
    }
    
    @GetMapping("/topic/name/{name}")
    public List<Topic> getTopicByName(@PathVariable("name") String name, @RequestParam(value = "count") int count) {
        logger.log();
        if (count == 0) {
            return new ArrayList<>();
        } else {
                return demoTopicComponent.getDemoTopicList().stream()
                        .filter(x -> name.equals(x.getName()))
                        .limit(1)
                        .collect(Collectors.toList());
            }
        }
    
    @GetMapping("/topic/theme/{theme}")
    public List<Topic> getTopicByTheme(@PathVariable("theme") String theme, @RequestParam(value = "count") int count) {
        logger.log();
        return demoTopicComponent.getDemoTopicList().stream()
                .filter(x -> theme.equals(x.getTheme()))
                .limit(count)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/topic/order")
    public List<Topic> getOrdered(@RequestParam(value = "order") boolean order) {
        logger.log();
        if (order) {
            return demoTopicComponent.getDemoTopicList().stream()
                    .sorted(new TopicComparator())
                    .collect(Collectors.toList());
        } else {
            return demoTopicComponent.getDemoTopicList();
        }
    }
    
}
