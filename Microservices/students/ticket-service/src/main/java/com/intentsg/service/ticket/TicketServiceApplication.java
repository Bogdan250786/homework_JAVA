package com.intentsg.service.ticket;

import com.intentsg.service.ticket.entity.Ticket;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;


import java.net.URI;
import java.net.URISyntaxException;

@EnableEurekaClient
@SpringBootApplication
public class TicketServiceApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(TicketServiceApplication.class, args);
    }
    
}
