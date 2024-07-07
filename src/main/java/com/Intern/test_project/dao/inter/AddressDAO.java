package com.Intern.test_project.dao.inter;

import com.Intern.test_project.domain.dto.AddressDto;

import java.util.List;

public interface AddressDAO {
    List<AddressDto> getAddressDtosByUserId(Long userId);
}
