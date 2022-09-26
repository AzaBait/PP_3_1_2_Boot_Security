package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.dto.UserDto;
import ru.kata.spring.boot_security.demo.entities.User;

import javax.validation.Valid;
import java.util.List;

public interface UserDao {
    List<User> getAllUsers ();
    User getById(Long id);
    void save( UserDto user);
    void delete(Long id);
    void update(UserDto user);
    User findByUsername(String username);
}
