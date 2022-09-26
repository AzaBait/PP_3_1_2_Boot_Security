package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.dto.UserDto;
import ru.kata.spring.boot_security.demo.entities.User;

import javax.validation.Valid;
import java.util.List;

public interface UserService {

 //   void save(User user,String[] roles);
    User save (@Valid UserDto user );
    User getById(Long id);
//    void update(User user,String[] roles);
    User update(UserDto user);
    void delete(Long id);
    List<User> getAllUsers();
    User findByUsername(String username);

    void saveRole (String role);
}
