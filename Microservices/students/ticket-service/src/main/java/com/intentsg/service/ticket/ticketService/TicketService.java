package com.intentsg.service.ticket.ticketService;

import com.intentsg.model.TicketDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class TicketService {
    
    @Autowired
    private DiscoveryClient discoveryClient;
    
    public String serviceUrl() {
        List<ServiceInstance> list = discoveryClient.getInstances("user-service");
        if (list != null && list.size() > 0 ) {
            return list.get(0).getUri().toString();
        }
        return null;
    }

    public List<TicketDTO> getAllTickets() {
        List<TicketDTO> tickets = new ArrayList<>();
        tickets.add(new TicketDTO(101, 1, 24, LocalDate.of(2021,1,15), 2));
        tickets.add(new TicketDTO(102, 1, 25, LocalDate.of(2021,1,12), 2));
        tickets.add(new TicketDTO(103, 2, 24, LocalDate.of(2021,2,13), 1));
        tickets.add(new TicketDTO(104, 5, 4, LocalDate.of(2021,1,17), 3));
        tickets.add(new TicketDTO(105, 5, 14, LocalDate.of(2021,2,2), 3));
        tickets.add(new TicketDTO(106, 3, 44, LocalDate.of(2021,3,22), 3));
        return tickets;
    }
}
