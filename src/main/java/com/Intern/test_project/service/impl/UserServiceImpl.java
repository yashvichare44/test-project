package com.Intern.test_project.service.impl;

import com.Intern.test_project.dao.inter.UserDAO;
import com.Intern.test_project.domain.dto.UserDto;
import com.Intern.test_project.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    public UserDto saveUser(UserDto userDto) {

        return userDAO.saveUser(userDto);
    }

    public List<UserDto> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public UserDto getUserById(Long id) {
        return userDAO.getUserById(id);
    }

    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }


    public UserDto updateUser(Long id, UserDto userDto) {
        return userDAO.updateUser(id, userDto);
    }

    public UserDto partialUpdateUser(Long id, UserDto userDto) {
        return userDAO.partialUpdateUser(id, userDto);
    }

}
