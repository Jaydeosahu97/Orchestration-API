package com.jay.orchestration.service;

import com.jay.orchestration.entity.User;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface UserService {
    /*
    * a. List of all available users
        b. List all users based on role
        c. List of users sorted by age in ascending or descending order
        d. Find a specific user by id or ssn
    * */

    String addAllUsers();

    List<User> getAllUsers();
    List<User> getUsersByRole(String role);
    List<User> getUsersByAgeOrder(Sort.Direction order);

    User getUsersByFilter(String name, String value);
}
