package com.jay.orchestration.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "maiden_name")
    private String maidenName;

    private int age;
    private String gender;
    private String email;
    private String phone;
    private String username;
    private transient String password;

    @Column(name = "birth_date")
    private String birthDate;

    private String image;

    @Column(name = "blood_group")
    private String bloodGroup;

    private double height;
    private double weight;

    @Column(name = "eye_color")
    private String eyeColor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "hair_id", referencedColumnName = "id")
    private Hair hair;

    private String ip;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @Column(name = "mac_address")
    private String macAddress;

    private String university;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bank_id", referencedColumnName = "id")
    private Bank bank;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id", referencedColumnName = "id")
    private Company company;

    private String ein;
    private String ssn;

    @Column(name = "user_agent")
    private String userAgent;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "crypto_id", referencedColumnName = "id")
    private Crypto crypto;

    private String role;

    @Entity
    @Table(name = "hair")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Hair {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String color;
        private String type;
    }

    @Entity
    @Table(name = "address")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Address {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String address;
        private String city;
        private String state;

        @Column(name = "state_code")
        private String stateCode;

        @Column(name = "postal_code")
        private String postalCode;

        private String country;

        private double lat;
        private double lng;


        @Entity
        @Table(name = "coordinates")
        @Data
        @NoArgsConstructor
        public static class Coordinates {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private int id;
            private double lat;
            private double lng;
        }
    }

    @Entity
    @Table(name = "bank")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Bank {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "card_expire")
        private String cardExpire;

        @Column(name = "card_number")
        private String cardNumber;

        @Column(name = "card_type")
        private String cardType;
        private String currency;
        private String iban;

    }

    @Entity
    @Table(name = "company")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Company {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String department;
        private String name;
        private String title;

        @OneToOne(cascade = CascadeType.ALL)
        @JoinColumn(name = "address_id", referencedColumnName = "id")
        private Address address;

    }

    @Entity
    @Table(name = "crypto")
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Crypto {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;
        private String coin;
        private String wallet;
        private String network;

    }
}
