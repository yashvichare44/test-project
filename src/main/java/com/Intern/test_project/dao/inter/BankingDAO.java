package com.Intern.test_project.dao.inter;


import com.Intern.test_project.domain.dto.BankingDto;

import java.util.List;

public interface BankingDAO {
    List<BankingDto> getBankingDetailsByUserId(Long userId);
}
