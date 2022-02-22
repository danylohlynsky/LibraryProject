package com.group4.service.implementations;

import com.group4.dao.interfaces.UserDAO;
import com.group4.model.Book;
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

//    @Override
//    @Transactional
//    public void addBook(User user) {
//        this.userDao.save(user);
//    }
//
//    @Override
//    @Transactional
//    public void updateBook(User user) {
//        this.userDao.update(user);
//    }
//
//    @Override
//    @Transactional
//    public void removeBook(int id) {
//        this.userDao.deleteById(id, User.class);
//    }
//
//    @Override
//    @Transactional
//    public User getUserById(int id) {
//        return (User) this.userDao.findById(id, User.class);
//    }
//
//    @Override
//    @Transactional
//    public List<User> listUser() {
//        return this.userDao.findAll(User.class);
//    }

    @Override
    @Transactional
    public void addUser(User user) {
        if(user.getId() == 0) {
            this.userDao.save(user);
        } else if (userDao.findById(user.getId(), Book.class) != null) {
            this.userDao.update(user);
        }
    }

    @Override
    @Transactional
    public User findById(int id) {
        return (User) userDao.findById(id, User.class);
    }

    @Override
    @Transactional
    public List<User> listUser() {
        return userDao.findAll(User.class);
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        this.userDao.save(user);
    }

    @Override
    @Transactional
    public User deleteById(int id) {
        return (User) this.userDao.findById(id, User.class);
    }
}
