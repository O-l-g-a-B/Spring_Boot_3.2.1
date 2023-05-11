package com.PP.SpringBoot.dao;
import com.PP.SpringBoot.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDaoImp implements UserDao {
    @PersistenceContext
    private EntityManager e;

    @Override
    public List<User> getListUsers() {
        return e.createQuery("FROM User", User.class).getResultList();
    }

    @Override
    public void addUser(User user) {
        e.persist(user);
    }

    @Override
    public void removeUser(Long id) {
        User user = e.find(User.class, id);
        e.remove(user);
    }

    @Override
    public User getUserById(long id) {
        return e.find(User.class, id);
    }

    @Override
    public void changeUser(User user) {
        e.merge(user);
    }

}