package com.intentsg.service.user.controller;

import com.intentsg.model.TicketDTO;
import com.intentsg.model.UserDTO;
import com.intentsg.service.user.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/users")
public class TestController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/{userId}/tickets")
    public ResponseEntity<List<TicketDTO>> getTickets(@PathVariable("userId") int userId) {
        String url = userService.serviceUrl() + "tickets/tickets";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<TicketDTO>> tickets = restTemplate.exchange(url, HttpMethod.GET, null,
                new ParameterizedTypeReference<List<TicketDTO>>() {
                });
        List<TicketDTO> collect = Objects.requireNonNull(tickets.getBody()).stream()
                .filter(x -> x.getUserId() == userId)
                .sorted(Comparator.comparing(TicketDTO::getDate))
                .collect(Collectors.toList());
        return ResponseEntity.ok(collect);
        
    }
    
    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
