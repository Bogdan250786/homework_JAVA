package com.ISG.paramud.SpringDemoApp.demo.repository;

import com.ISG.paramud.SpringDemoApp.demo.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface TopicRepository extends JpaRepository<Topic, Long> {
    
    @Query("select item from Topic as item where item.name = :name")
    List<Topic> getTopicByName(@Param("name") String name);
    
    @Query("select item from Topic as item where item.theme = :theme")
    List<Topic> getTopicsByTheme(@Param("theme") String theme);
}
