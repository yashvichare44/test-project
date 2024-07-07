package com.Intern.test_project.dao.impl;

import com.Intern.test_project.dao.inter.UserDAO;
import com.Intern.test_project.domain.dto.UserDto;
import com.Intern.test_project.domain.entities.User;
import com.Intern.test_project.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Transactional
@Service
public class UserDAOImpl implements UserDAO {

    @Autowired
    private UserRepository userRepository;

    public UserDto saveUser(UserDto userDto) {
        User user = convertToEntity(userDto);
        user = userRepository.save(user);
        return convertToDto(user);
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    public UserDto getUserById(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.map(this::convertToDto).orElse(null);
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public UserDto updateUser(Long id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPassword(userDto.getPassword());
            user = userRepository.save(user);
            return convertToDto(user);
        }
        return null;
    }

    public UserDto partialUpdateUser(Long id, UserDto userDto) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (userDto.getPassword() != null) {
                user.setPassword(userDto.getPassword());
            }
            user = userRepository.save(user);
            return convertToDto(user);
        }
        return null;
    }

    private User convertToEntity(UserDto userDto) {
        User user = new User();
        BeanUtils.copyProperties(userDto, user);
        return user;
    }

    private UserDto convertToDto(User user) {
        UserDto userDto = new UserDto();
        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }
}



