package com.Intern.test_project.domain.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressDto {

    private int id;
    private String address;
    private String city;
    private String country;
    private String email;
    private String pinCode;
    private String state;

    // Getters and Setters
}
