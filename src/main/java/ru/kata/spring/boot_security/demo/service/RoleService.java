package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.entities.Role;

import java.util.List;
import java.util.Set;

public interface RoleService {

 //   Set<Role> getAllRoles (String[] roleNames);
 List<Role> getAllRoles ();
    Role getById(Long id);
    void save(Role role);
    void delete(Long id);
    void update(Role role);
    Role findByName(String name);


}
