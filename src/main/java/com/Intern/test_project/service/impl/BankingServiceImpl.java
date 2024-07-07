package com.Intern.test_project.service.impl;

import com.Intern.test_project.dao.impl.BankingDAOImpl;
import com.Intern.test_project.domain.dto.BankingDto;
import com.Intern.test_project.service.inter.BankingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankingServiceImpl implements BankingService {

    @Autowired
    private BankingDAOImpl bankingDAO;

    public List<BankingDto> getBankingDetailsByUserId(Long userId) {
        return bankingDAO.getBankingDetailsByUserId(userId);
    }
}
