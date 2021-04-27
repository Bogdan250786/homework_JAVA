package com.intentsg.service.user.userService;

import com.intentsg.model.UserDTO;
import com.intentsg.service.user.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    
    public UserService(DiscoveryClient discoveryClient) {
        this.discoveryClient = discoveryClient;
    }
    
    private final DiscoveryClient discoveryClient;
    
    public String serviceUrl() {
        List<ServiceInstance> list = discoveryClient.getInstances("ticket-service");
        if (list != null && list.size() > 0) {
            return list.get(0).getUri().toString();
        }
        return null;
    }
    
    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();
        users.add(new UserDTO(1, "Myhaylo", "Mural"));
        users.add(new UserDTO(2, "Andriy", "Sadovyi"));
        users.add(new UserDTO(3, "Bogdan", "Rudyk"));
        users.add(new UserDTO(4, "Vasyl", "Dudka"));
        users.add(new UserDTO(5, "Petro", "Kema"));
        users.add(new UserDTO(6, "Ivan", "Trush"));
        return users;
        
    }
}
