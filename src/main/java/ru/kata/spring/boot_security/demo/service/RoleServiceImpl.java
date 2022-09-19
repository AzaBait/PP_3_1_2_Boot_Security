package ru.kata.spring.boot_security.demo.service;

import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.entities.Role;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService{
    private RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

//    @Override
//    public Set<Role> getAllRoles(String[] roleNames) {
//        return roleDao.getAllRoles(roleNames);
//    }

    @Override
    public List<Role> getAllRoles() {
        return roleDao.getAllRoles();
    }

    @Override
    public Role getById(Long id) {
        return roleDao.getById(id);
    }

    @Override
    public void save(Role role) {
    roleDao.save(role);
    }

    @Override
    public void delete(Long id) {
    roleDao.delete(id);
    }

    @Override
    public void update(Role role) {
    roleDao.update(role);
    }

    @Override
    public Role findByName(String name) {
        return roleDao.findByName(name);
    }
}
