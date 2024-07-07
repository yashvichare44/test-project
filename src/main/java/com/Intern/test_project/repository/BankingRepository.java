package com.Intern.test_project.repository;

import com.Intern.test_project.domain.entities.Banking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BankingRepository extends JpaRepository<Banking, Long> {
    List<Banking> findByUserId(Long userId);
}
