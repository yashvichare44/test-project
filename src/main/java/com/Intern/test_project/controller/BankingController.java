package com.Intern.test_project.controller;

import com.Intern.test_project.domain.dto.BankingDto;
import com.Intern.test_project.service.impl.BankingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/banking")
public class BankingController {

    @Autowired
    private BankingServiceImpl bankingService;

    @GetMapping("/{userId}")
    public List<BankingDto> getUserBanking(@PathVariable Long userId) {
        return bankingService.getBankingDetailsByUserId(userId);
    }
}





