package com.group4.service.implementations;

import com.group4.dao.interfaces.UserDAO;
import com.group4.model.User;
import com.group4.service.interfaces.UserService;
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
        this.userDao.save(user);
    }

    @Override
    @Transactional
    public void updateBook(User user) {
        this.userDao.update(user);
    }

    @Override
    @Transactional
    public void removeBook(int id) {
        this.userDao.deleteById(id);
    }

    @Override
    @Transactional
    public User getUserById(int id) {
        return this.userDao.findById(id);
    }

    @Override
    @Transactional
    public List<User> listUser() {
        return this.userDao.findAll();
    }
}
