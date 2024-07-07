package com.Intern.test_project.service.inter;

import com.Intern.test_project.domain.dto.AddressDto;

import java.util.List;

public interface AddressService {
     List<AddressDto> getAddressDtosByUserId(Long userId);
}
