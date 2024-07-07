package com.Intern.test_project.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_banking")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Banking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bankAccountNumber;
    private String bankName;
    private String accountHolderName;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


}
