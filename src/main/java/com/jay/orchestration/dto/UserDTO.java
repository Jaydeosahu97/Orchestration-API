package com.jay.orchestration.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
public class UserDTO implements Serializable {
    private int id;
    private String firstName;
    private String lastName;
    private String maidenName;
    private int age;
    private String gender;
    private String email;
    private String phone;
    private String username;
    private String password;
//    @JsonFormat(pattern="yyyy-MM-dd")
    private String birthDate;
    private String image;
    private String bloodGroup;
    private double height;
    private double weight;
    private String eyeColor;
    private Hair hair;
    private String ip;
    private Address address;
    private String macAddress;
    private String university;
    private Bank bank;
    private Company company;
    private String ein;
    private String ssn;
    private String userAgent;
    private Crypto crypto;
    private String role;

    @Data
    @AllArgsConstructor
    public static class Hair {
        private String color;
        private String type;
    }

    @Data
    @AllArgsConstructor
    public static class Address {
        private String address;
        private String city;
        private String state;
        private String stateCode;
        private String postalCode;
        private Coordinates coordinates;
        private String country;

        @Data
        @AllArgsConstructor
        public static class Coordinates {
            private double lat;
            private double lng;
        }
    }

    @Data
    @AllArgsConstructor
    public static class Bank {
        private String cardExpire;
        private String cardNumber;
        private String cardType;
        private String currency;
        private String iban;
    }

    @Data
    @AllArgsConstructor
    public static class Company {
        private String department;
        private String name;
        private String title;
        private Address address;
    }

    @Data
    @AllArgsConstructor
    public static class Crypto {
        private String coin;
        private String wallet;
        private String network;
    }
}
