package com.Intern.test_project.controller;

import com.Intern.test_project.domain.dto.AddressDto;
import com.Intern.test_project.service.impl.AddressServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressServiceImpl addressService;

    @GetMapping("/{userId}")
    public List<AddressDto> getUserAddresses(@PathVariable Long userId) {
        return addressService.getAddressDtosByUserId(userId);
    }
}
