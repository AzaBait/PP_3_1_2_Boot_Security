package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dao.RoleDao;
import ru.kata.spring.boot_security.demo.dao.UserDao;
import ru.kata.spring.boot_security.demo.dto.UserDto;
import ru.kata.spring.boot_security.demo.entities.User;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    private UserDao userDao;
    private RoleDao roleDao;
    private PasswordEncoder passwordEncoder;



//    public void registerDefaultUser(User user){
//        Role roleUser = roleDao.findByName("User");
//        user.addRole(roleUser);
//        userDao.save(user);
//    }
//    @Override
//    @Transactional
//    public void save(User user,String[] roles) {
//        user.setRoles( roleDao.getAllRoles(roles));
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//    userDao.save(user);
//    }

    @Override
    @Transactional
    public User save(@Valid UserDto user) {
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userDao.save(user);
        return null;
    }

    @Override
    public User getById(Long id) {
        return userDao.getById(id);
    }

    @Override
    @Transactional
    public User update(UserDto user) {
        userDao.update(user);
        return null;
    }

//    @Override
//    @Transactional
//    public void update(User user,String[] roles) {
//        user.setRoles( roleDao.getAllRoles(roles));
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//    userDao.update(user);
//    }

    @Override
    @Transactional
    public void delete(Long id) {
    userDao.delete(id);
    }

    public UserServiceImpl(UserDao userDao, RoleDao roleDao, PasswordEncoder passwordEncoder) {
        this.userDao = userDao;
        this.roleDao = roleDao;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User findByUsername(String username) {
        return userDao.findByUsername(username);
    }

    @Override
    public void saveRole(String role) {
        roleDao.save(role);
    }
}
