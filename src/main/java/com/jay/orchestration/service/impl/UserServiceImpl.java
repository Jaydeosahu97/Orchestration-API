package com.jay.orchestration.service.impl;

import com.jay.orchestration.dto.DummyJsonResponse;
import com.jay.orchestration.entity.User;
import com.jay.orchestration.mapper.UserMapper;
import com.jay.orchestration.repository.UserRepository;
import com.jay.orchestration.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private static final String DUMMY_JSON_USER_URL = "https://dummyjson.com/users?limit=0";
    private static final String ID = "id";
    private static final String SSN = "ssn";

    private final RestClient restClient;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(RestClient restClient, UserRepository userRepository, UserMapper userMapper) {
        this.restClient = restClient;
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public String addAllUsers() {
        RestTemplate restTemplate = new RestTemplate();

        log.info("Fetching all users from {}", DUMMY_JSON_USER_URL);

        DummyJsonResponse users = restClient.get()
                .uri(DUMMY_JSON_USER_URL)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError,(_, response) -> log.error("Error fetching users from {} with status {} and text {}",DUMMY_JSON_USER_URL,response.getStatusCode(),response.getStatusText()))
                .body(new ParameterizedTypeReference<>() {});

        log.info("Fetched {} users", users.getUsers().size());

        log.info("Saving all the fetched users to the database");
        userRepository.saveAll(users.getUsers().stream().map(userMapper).toList());
        return "Users added successfully";
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> getUsersByRole(String role) {
        log.info("Fetching all users with role {}", role);
        return userRepository.findByRole(role);
    }

    @Override
    public List<User> getUsersByAgeOrder(Sort.Direction order) {
        log.info("Fetching all users sorted by age in {}", order);
        return switch (order) {
            case DESC -> userRepository.findAll(Sort.by("age").descending());
            case ASC -> userRepository.findAll(Sort.by("age").ascending());
        };
    }

    @Override
    public User getUsersByFilter(String name, String value) {
        log.info("Fetching all users with {} as {}", name, value);

        return switch (name) {
            case ID -> userRepository.findById(Integer.parseInt(value)).orElse(null);
            case SSN -> userRepository.findBySsn(value).orElse(null);
            default -> throw new IllegalArgumentException("Invalid filter");
        };
    }

}
