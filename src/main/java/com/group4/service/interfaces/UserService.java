package com.group4.service.interfaces;

import com.group4.model.User;
import java.util.List;

public interface UserService {
    User findById(int id);

    List<User> findAll();

    void saveUser(User user);

    User deleteById(int id);



}
