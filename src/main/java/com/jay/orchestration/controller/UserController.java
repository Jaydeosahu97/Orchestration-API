package com.jay.orchestration.controller;

import com.jay.orchestration.entity.User;
import com.jay.orchestration.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/add-all")
    public ResponseEntity<String> addAllUsers(){
        log.info("Adding all users");
        String response = userService.addAllUsers();
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        log.info("Fetching all users");
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/role/{role}")
    public ResponseEntity<List<User>> getUsersByRole(@PathVariable String role) {
        return ResponseEntity.ok(userService.getUsersByRole(role));
    }

    @GetMapping("/age")
    public ResponseEntity<List<User>> getUsersByAgeOrder(@RequestParam("order") Sort.Direction order){
        return ResponseEntity.ok(userService.getUsersByAgeOrder(order));
    }

    @GetMapping("/filter/{name}/{value}")
    public ResponseEntity<User> getUsersByFilter(@PathVariable String name, @PathVariable String value){
        return ResponseEntity.ok(userService.getUsersByFilter(name, value));
    }
}
