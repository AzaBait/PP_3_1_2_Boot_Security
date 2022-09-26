package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.entities.Role;

import java.util.List;

public interface RoleDao {
//    Set<Role> getAllRoles (String [] roleNames);
    List<Role> getAllRoles();
    Role getById(Long id);
    void save(String role);
    void delete(Long id);
    void update(Role role);
    Role findByName(String name);
}
