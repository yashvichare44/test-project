package com.Intern.test_project.dao.impl;

import com.Intern.test_project.dao.inter.AddressDAO;
import com.Intern.test_project.domain.dto.AddressDto;
import com.Intern.test_project.domain.entities.Address;
import com.Intern.test_project.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class AddressDAOImpl implements AddressDAO {

    @Autowired
    private AddressRepository addressRepository;

    public List<AddressDto> getAddressDtosByUserId(Long userId) {
        List<Address> addresses = addressRepository.findByUserId(userId);
        return addresses.stream()
                .map(this::convertToAddressDto)
                .collect(Collectors.toList());
    }

    private AddressDto convertToAddressDto(Address address) {
        AddressDto addressDto = new AddressDto();
        addressDto.setId( address.getId());
        addressDto.setAddress(address.getAddress());
        addressDto.setCity(address.getCity());
        addressDto.setState(address.getState());
        addressDto.setCountry(address.getCountry());
        addressDto.setPinCode(address.getPinCode());
        addressDto.setEmail(address.getEmail());
        return addressDto;
    }
}
