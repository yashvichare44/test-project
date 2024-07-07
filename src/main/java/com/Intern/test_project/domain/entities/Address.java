package com.Intern.test_project.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_address")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String city;
    private String pinCode;
    private String email;
    private String address;
    private String country;
    private String state;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
