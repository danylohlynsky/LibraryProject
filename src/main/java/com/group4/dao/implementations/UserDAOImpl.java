package com.group4.dao.implementations;

import com.group4.dao.interfaces.UserDAO;
import com.group4.model.User;

import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDAOImpl extends DAOImpl<User> implements UserDAO {
    public UserDAOImpl(LocalSessionFactoryBean localSessionFactoryBean) {
        super(localSessionFactoryBean);
    }

/*

    @Override
    public User getUserById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = session.load(User.class, id);
        logger.info("User successfully loaded. User details: " + user);

        return user;
    }

*/
/*
    @Override
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> userList = session.createQuery("from User").list();

        for (User user : userList) {
            logger.info("User list: " + user);
        }
        return userList;
    }
*/
}
