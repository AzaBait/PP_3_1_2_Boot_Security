package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.dto.UserDto;
import ru.kata.spring.boot_security.demo.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List getAllUsers() {
        return entityManager.createQuery("select u from User u").getResultList();
    }

    @Override
    public User getById(Long id) {

        return entityManager.find(User.class, id);
    }

    @Override
    public void save(UserDto user) {
        entityManager.persist(user);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public void update(UserDto user) {
        entityManager.merge(user);
    }

    @Override
    public User findByUsername(String username) {
       return (User) entityManager.createQuery(
               "select u from User u where u.username = ?1").setParameter(1,username).getSingleResult();

    }
}
