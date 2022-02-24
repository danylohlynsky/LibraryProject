package com.group4.service.interfaces;

import com.group4.model.Book;
import com.group4.model.User;

import java.util.List;

public interface UserService {
    void addUser(User user);

    User findById(int id);

    List<User> listUser();

    void saveUser(User user);

    User deleteById(int id);

    void deleteUser(User user);
}
