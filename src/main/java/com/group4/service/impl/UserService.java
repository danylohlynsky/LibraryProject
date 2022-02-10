package com.group4.service.impl;

import com.group4.model.User;
import java.util.List;

public interface UserService {
    void addBook(User user);

    void updateBook(User user);

    void removeBook(int id);

    User getUserById(int id);

    List<User> listUser();
}
