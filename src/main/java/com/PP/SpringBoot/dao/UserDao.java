package com.PP.SpringBoot.dao;


import com.PP.SpringBoot.model.User;

import java.util.List;

public interface UserDao {
    List<User> getListUsers();
    void addUser(User user);
    void removeUser(Long id);
    User getUserById(long id);
    void changeUser(User user);
}
