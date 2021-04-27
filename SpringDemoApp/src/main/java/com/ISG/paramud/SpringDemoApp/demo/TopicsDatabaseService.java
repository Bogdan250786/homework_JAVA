package com.ISG.paramud.SpringDemoApp.demo;

import com.ISG.paramud.SpringDemoApp.demo.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
public class TopicsDatabaseService {
    
    @Autowired
    TopicRepository topicRepository;
    
    @Transactional
    public void addToDatabase() {
        topicRepository.save(new Topic(1L, "Lviv", "News", LocalDate.of(2016, 1, 1)));
        topicRepository.save(new Topic(2L, "Lviv", "Transport", LocalDate.of(2018, 3, 6)));
        topicRepository.save(new Topic(3L, "Lviv", "City Life", LocalDate.of(2018, 3, 6)));
        topicRepository.save(new Topic(4L, "Lviv", "Citizens", LocalDate.of(2018, 3, 6)));
        topicRepository.save(new Topic(5L, "Lviv", "Map", LocalDate.of(2018, 3, 6)));
        topicRepository.save(new Topic(6L, "Lviv", "Museums", LocalDate.of(2018, 3, 6)));
        topicRepository.save(new Topic(7L, "Lviv", "Shops", LocalDate.of(2018, 3, 6)));
        topicRepository.save(new Topic(8L, "Kiev", "News", LocalDate.of(2016, 1, 1)));
        topicRepository.save(new Topic(9L, "Kiev", "Transport", LocalDate.of(2019, 3, 16)));
        topicRepository.save(new Topic(10L, "Kiev", "City Life", LocalDate.of(2008, 3, 26)));
        topicRepository.save(new Topic(11L, "Kiev", "Citizens", LocalDate.of(2021, 1, 6)));
        topicRepository.save(new Topic(12L, "Kiev", "Map", LocalDate.of(2012, 2, 11)));
        topicRepository.save(new Topic(13L, "Kiev", "Museums", LocalDate.of(2018, 8, 14)));
        topicRepository.save(new Topic(14L, "Kiev", "Shops", LocalDate.of(2019, 10, 21)));
        topicRepository.save(new Topic(15L, "Lutsk", "News", LocalDate.of(2011, 1, 1)));
        topicRepository.save(new Topic(16L, "Lutsk", "Transport", LocalDate.of(2019, 9, 16)));
        topicRepository.save(new Topic(17L, "Lutsk", "City Life", LocalDate.of(2008, 4, 26)));
        topicRepository.save(new Topic(18L, "Lutsk", "Citizens", LocalDate.of(2020, 7, 6)));
        topicRepository.save(new Topic(19L, "Lutsk", "Map", LocalDate.of(2012, 9, 11)));
        topicRepository.save(new Topic(20L, "Lutsk", "Museums", LocalDate.of(2018, 4, 14)));
        topicRepository.save(new Topic(21L, "Lutsk", "Shops", LocalDate.of(2019, 7, 25)));
        topicRepository.save(new Topic(22L, "Ternopil", "News", LocalDate.of(2011, 8, 23)));
        topicRepository.save(new Topic(23L, "Ternopil", "Transport", LocalDate.of(2019, 11, 18)));
        topicRepository.save(new Topic(24L, "Ternopil", "City Life", LocalDate.of(2008, 8, 2)));
        topicRepository.save(new Topic(25L, "Ternopil", "Citizens", LocalDate.of(2011, 9, 26)));
        topicRepository.save(new Topic(26L, "Ternopil", "Map", LocalDate.of(2002, 9, 11)));
        topicRepository.save(new Topic(27L, "Ternopil", "Museums", LocalDate.of(2019, 3, 17)));
        topicRepository.save(new Topic(28L, "Ternopil", "Shops", LocalDate.of(2019, 9, 25)));
    }
}
