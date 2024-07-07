package com.Intern.test_project.service.impl;

import com.Intern.test_project.dao.impl.AddressDAOImpl;
import com.Intern.test_project.domain.dto.AddressDto;
import com.Intern.test_project.service.inter.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressDAOImpl addressDAO;

    public List<AddressDto> getAddressDtosByUserId(Long userId) {
        return addressDAO.getAddressDtosByUserId(userId);
    }
}
