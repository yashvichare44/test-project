package com.Intern.test_project.dao.inter;

import com.Intern.test_project.domain.dto.UserDto;

import java.util.List;

public interface UserDAO {
    UserDto saveUser(UserDto userDto);

    List<UserDto> getAllUsers();

    UserDto getUserById(Long id);

    void deleteUser(Long id);

    UserDto updateUser(Long id, UserDto userDto);

    UserDto partialUpdateUser(Long id, UserDto userDto);
}
