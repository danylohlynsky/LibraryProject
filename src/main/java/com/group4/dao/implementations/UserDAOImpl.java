package com.group4.dao.implementations;

import com.group4.dao.interfaces.UserDAO;
import com.group4.model.User;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDAOImpl extends DAOImpl<User> implements UserDAO {
    public UserDAOImpl(LocalSessionFactoryBean localSessionFactoryBean) {
        super(localSessionFactoryBean);
    }

    public List<User> findAll() {
        return super.findAll(User.class);
    }

    public User findByMail(String email) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            Query query = session.createQuery(
                    "from User U where U.email like :email"
            );
            query.setParameter("email", email);
            List<User> users = query.list();
            User user = null;
            if (users.size() >= 1)
                user = users.get(0);
            session.getTransaction().commit();
            return user;
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            System.out.println("Error performing JPA operation. Transaction is rolled back");
        } finally {
            session.close();
        }
        return null;
    }
}
