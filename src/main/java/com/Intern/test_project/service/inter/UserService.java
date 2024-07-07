package com.Intern.test_project.service.inter;

import com.Intern.test_project.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto saveUser(UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    UserDto updateUser(Long id, UserDto userDto);

    UserDto partialUpdateUser(Long id, UserDto userDto);

    void deleteUser(Long id);

}
