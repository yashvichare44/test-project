package com.Intern.test_project.service.inter;

import com.Intern.test_project.domain.dto.BankingDto;

import java.util.List;

public interface BankingService {
    List<BankingDto> getBankingDetailsByUserId(Long userId);
}
