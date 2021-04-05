package com.ISG.paramud.SpringDemoApp.demo;

import com.ISG.paramud.SpringDemoApp.demo.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SpringDemoAppController {
    
    @Autowired
    DemoTopicService demoTopicService;
    
    @Autowired
    TopicRepository topicRepository;
    
    @Autowired
    TopicsDatabaseService topicsDatabaseService;
    
    @GetMapping("/topic")
    public List<Topic> getAllReservations() {
        topicsDatabaseService.addToDatabase();
        return demoTopicService.getDemoTopicList();
    }
    
    @GetMapping("/topic/name/{name}")
    public List<Topic> getTopicByNameWithParams(@PathVariable("name") String name,
                                                @RequestParam(value = "count") int count) {
        if (count == 0) {
            return new ArrayList<>();
        } else {
            return demoTopicService.getDemoTopicList().stream()
                    .filter(x -> name.equals(x.getName()))
                    .limit(1)
                    .collect(Collectors.toList());
        }
    }
    
    @GetMapping("/topic/theme/{theme}")
    public List<Topic> getTopicsByThemeWithParams(@PathVariable("theme") String theme,
                                                  @RequestParam(value = "count") int count) {
        return demoTopicService.getDemoTopicList().stream()
                .filter(x -> theme.equals(x.getTheme()))
                .limit(count)
                .collect(Collectors.toList());
    }
    
    @GetMapping("/topic/topictheme/{theme}")
    public List<Topic> getTopicsByThemeDB(@PathVariable("theme") String theme) {
        List<Topic> themes = topicRepository.getTopicsByTheme(theme);
        return themes;
    }
    
    @GetMapping("/topic/topicname/{name}")
    public Topic getTopicByName(@PathVariable("name") String name) {
        Topic topic = topicRepository.getTopicByName(name).stream()
                .findFirst()
                .orElse(null);
        return topic;
    }
    
    @GetMapping("/topic/order")
    public List<Topic> getOrdered(@RequestParam(value = "order") boolean order) {
        if (order) {
            return demoTopicService.getDemoTopicList().stream()
                    .sorted(new TopicComparator())
                    .collect(Collectors.toList());
        } else {
            return demoTopicService.getDemoTopicList();
        }
    }
}
