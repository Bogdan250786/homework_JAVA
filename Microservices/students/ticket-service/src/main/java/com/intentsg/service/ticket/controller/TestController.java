package com.intentsg.service.ticket.controller;

import com.intentsg.model.TicketDTO;
import com.intentsg.model.UserDTO;
import com.intentsg.service.ticket.ticketService.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Objects;

@Controller
@RequestMapping("/tickets")
public class TestController {

	@Autowired
	TicketService ticketService;
	
	@GetMapping("/tickets")
	public ResponseEntity<List<TicketDTO>> getTickets() {
		return ResponseEntity.ok(ticketService.getAllTickets());
	}
	@GetMapping("/{ticketId}/user")
	public ResponseEntity<?> getTickets(@PathVariable("ticketId") int ticketId) {
		String url = ticketService.serviceUrl() + "/users/users";
		RestTemplate restTemplate = new RestTemplate();
		TicketDTO ticket = ticketService.getAllTickets().stream()
				.filter(x -> x.getTicketId() == ticketId)
				.findFirst()
				.orElse(null);
		ResponseEntity<List<UserDTO>> users = restTemplate.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<UserDTO>>() {});
		if (ticket == null) return ResponseEntity.ok(HttpStatus.BAD_GATEWAY);
		else {
			return ResponseEntity.ok(Objects.requireNonNull(Objects.requireNonNull(users.getBody()).stream()
					.filter(x -> x.getUserId() == ticket.getUserId())
					.findFirst()
					.orElse(null)));
		}
	}
}
