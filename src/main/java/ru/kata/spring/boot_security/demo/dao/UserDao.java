package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.entities.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers ();
    User getById(Long id);
    void save(User user);
    void delete(Long id);
    void update(User user);
    User findByUsername(String username);
}
