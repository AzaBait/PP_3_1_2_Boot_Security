package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.entities.Role;
import ru.kata.spring.boot_security.demo.entities.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Set;

@Repository
public class RoleDaoImpl implements RoleDao{
    @PersistenceContext
    private EntityManager entityManager;

//    @Override
//    public Set<Role> getAllRoles(String [] roleNames) {
//        return (Set<Role>) entityManager.createQuery("select r from Role r").getResultList();
//    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery("select r from Role r").getResultList();
    }

    @Override
    public Role getById(Long id) {
        return entityManager.find(Role.class,id);
    }


    @Override
    public void save(Role role) {
        entityManager.persist(role);
    }

    @Override
    public void delete(Long id) {
        entityManager.remove(getById(id));
    }

    @Override
    public void update(Role role) {
        entityManager.merge(role);
    }

    @Override
    public Role findByName(String name) {
        return (Role) entityManager.createQuery(
                " select r from Role r where r.name = ?1").setParameter(1,name).getSingleResult();
    }


}
