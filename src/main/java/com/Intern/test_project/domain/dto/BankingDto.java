package com.Intern.test_project.domain.dto;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BankingDto {

    private int id;
    private String bankAccountNumber;
    private String bankName;
    private String accountHolderName;
}
