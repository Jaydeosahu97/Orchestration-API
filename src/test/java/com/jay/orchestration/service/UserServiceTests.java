package com.jay.orchestration.service;

import com.jay.orchestration.entity.User;
import com.jay.orchestration.repository.UserRepository;
import com.jay.orchestration.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class UserServiceTests {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllUsers() {
        List<User> users = users();
        when(userRepository.findAll()).thenReturn(users);

        List<User> result = userService.getAllUsers();

        assertEquals(users, result);
    }

    @Test
    void testGetUsersByRole() {
        String role = "Admin";
        List<User> users = Collections.singletonList(users().getFirst());
        when(userRepository.findByRole(role)).thenReturn(users);

        List<User> result = userService.getUsersByRole(role);

        assertEquals(users, result);
    }

    @Test
    void testGetUsersByAgeOrder() {
        List<User> users = users().stream().sorted(Comparator.comparingInt(User::getAge)).toList();
        when(userRepository.findAll(Sort.by(Sort.Direction.ASC, "age"))).thenReturn(users);

        List<User> result = userService.getUsersByAgeOrder(Sort.Direction.ASC);

        assertEquals(users, result);
    }

    @Test
    void testGetUsersByFilterId() {
        String filterName = "id";
        String filterValue = "1";
        Optional<User> users = Optional.of(users().getFirst());
        User usersList = users.get();
        when(userRepository.findById(Integer.parseInt(filterValue))).thenReturn(users);

        User result = userService.getUsersByFilter(filterName, filterValue);

        assertEquals(usersList, result);
    }

    @Test
    void testGetUsersByFilterSsn() {
        String filterName = "ssn";
        String filterValue = "123-45-6789";
        Optional<User> users = Optional.of(users().getFirst());
        User usersList = users.get();
        when(userRepository.findBySsn(filterValue)).thenReturn(users);

        User result = userService.getUsersByFilter(filterName, filterValue);

        assertEquals(usersList, result);
    }

    List<User> users() {
        User user1 = new User();
        user1.setId(1);
        user1.setFirstName("John");
        user1.setLastName("Doe");
        user1.setMaidenName("Smith");
        user1.setAge(30);
        user1.setGender("Male");
        user1.setEmail("john.doe@example.com");
        user1.setPhone("123-456-7890");
        user1.setUsername("johndoe");
        user1.setPassword("password");
        user1.setBirthDate("1993-01-01");
        user1.setImage("image_url");
        user1.setBloodGroup("O+");
        user1.setHeight(180.5);
        user1.setWeight(75.0);
        user1.setEyeColor("Blue");
        user1.setHair(new User.Hair(1, "Brown", "Curly"));
        user1.setIp("192.168.1.1");
        user1.setAddress(new User.Address(1, "123 Main St", "Springfield", "IL", "IL", "62701", "USA", 39.7817, -89.6501));
        user1.setMacAddress("00:1A:2B:3C:4D:5E");
        user1.setUniversity("Springfield University");
        user1.setBank(new User.Bank(1, "12/23", "1234-5678-9012-3456", "Visa", "USD", "US1234567890"));
        user1.setCompany(new User.Company(1, "IT", "Tech Corp", "Developer", new User.Address(2, "456 Elm St", "Springfield", "IL", "IL", "62702", "USA", 39.7817, -89.6501)));
        user1.setEin("12-3456789");
        user1.setSsn("123-45-6789");
        user1.setUserAgent("Mozilla/5.0");
        user1.setCrypto(new User.Crypto(1, "Bitcoin", "1A1zP1eP5QGefi2DMPTfTL5SLmv7DivfNa", "BTC"));
        user1.setRole("Admin");

        User user2 = new User();
        user2.setId(2);
        user2.setFirstName("Jane");
        user2.setLastName("Doe");
        user2.setMaidenName("Johnson");
        user2.setAge(28);
        user2.setGender("Female");
        user2.setEmail("jane.doe@example.com");
        user2.setPhone("098-765-4321");
        user2.setUsername("janedoe");
        user2.setPassword("password");
        user2.setBirthDate("1995-02-02");
        user2.setImage("image_url");
        user2.setBloodGroup("A+");
        user2.setHeight(165.0);
        user2.setWeight(60.0);
        user2.setEyeColor("Green");
        user2.setHair(new User.Hair(2, "Blonde", "Straight"));
        user2.setIp("192.168.1.2");
        user2.setAddress(new User.Address(3, "789 Oak St", "Springfield", "IL", "IL", "62703", "USA", 39.7817, -89.6501));
        user2.setMacAddress("00:1A:2B:3C:4D:5F");
        user2.setUniversity("Springfield University");
        user2.setBank(new User.Bank(2, "11/24", "2345-6789-0123-4567", "MasterCard", "USD", "US2345678901"));
        user2.setCompany(new User.Company(2, "HR", "Tech Corp", "Manager", new User.Address(4, "101 Pine St", "Springfield", "IL", "IL", "62704", "USA", 39.7817, -89.6501)));
        user2.setEin("23-4567890");
        user2.setSsn("234-56-7890");
        user2.setUserAgent("Mozilla/5.0");
        user2.setCrypto(new User.Crypto(2, "Ethereum", "0x32Be343B94f860124dC4fEe278FDCBD38C102D88", "ETH"));
        user2.setRole("User");

        return Arrays.asList(user1, user2);
    }
}