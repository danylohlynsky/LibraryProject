package com.group4.service;

import com.group4.dao.impl.UserDAO;
import com.group4.model.User;
import com.group4.service.impl.UserService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Setter
public class UserServiceImpl implements UserService {
    private UserDAO userDao;

    @Autowired
    public UserServiceImpl(UserDAO userDao) {
        this.userDao = userDao;
    }

    @Override
    @Transactional
    public void addBook(User user) {
        this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public void updateBook(User user) {
        this.userDao.addUser(user);
    }

    @Override
    @Transactional
    public void removeBook(int id) {
        this.userDao.removeUser(id);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return this.userDao.getUserById(id);
    }

    @Override
    @Transactional
    public List<User> listUser() {
        return this.userDao.listUsers();
    }
}
