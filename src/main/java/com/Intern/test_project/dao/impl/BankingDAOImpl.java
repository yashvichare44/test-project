package com.Intern.test_project.dao.impl;

import com.Intern.test_project.dao.inter.BankingDAO;
import com.Intern.test_project.domain.dto.BankingDto;
import com.Intern.test_project.domain.entities.Banking;
import com.Intern.test_project.repository.BankingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BankingDAOImpl implements BankingDAO {

    @Autowired
    private BankingRepository bankingRepository;

    @Override
    public List<BankingDto> getBankingDetailsByUserId(Long userId) {
        List<Banking> bankingDetails = bankingRepository.findByUserId(userId);
        return bankingDetails.stream()
                .map(this::convertToBankingDto)
                .collect(Collectors.toList());
    }

    private BankingDto convertToBankingDto(Banking banking) {
        BankingDto bankingDto = new BankingDto();
        bankingDto.setId(banking.getId());
        bankingDto.setBankAccountNumber(banking.getBankAccountNumber());
        bankingDto.setBankName(banking.getBankName());
        bankingDto.setAccountHolderName(banking.getAccountHolderName());
        return bankingDto;
    }
}


