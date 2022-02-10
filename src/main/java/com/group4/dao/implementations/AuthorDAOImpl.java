package com.group4.dao.implementations;

import com.group4.dao.interfaces.AuthorDAO;
import com.group4.model.Author;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

@Repository
public class AuthorDAOImpl extends DAOImpl<Author> implements AuthorDAO {
    public AuthorDAOImpl(LocalSessionFactoryBean localSessionFactoryBean) {
        super(localSessionFactoryBean);
    }
}
