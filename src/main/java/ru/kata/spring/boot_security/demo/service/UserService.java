package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;

public interface UserService {

 //   void save(User user,String[] roles);
    void save (User user );
    User getById(Long id);
//    void update(User user,String[] roles);
    void update(User user);
    void delete(Long id);
    List<User> getAllUsers();
    User findByUsername(String username);
}
