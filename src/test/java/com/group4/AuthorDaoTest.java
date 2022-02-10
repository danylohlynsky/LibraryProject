package com.group4;

import com.group4.config.SpringConfig;
import com.group4.dao.implementations.AuthorDAOImpl;
import com.group4.dao.interfaces.AuthorDAO;
import com.group4.model.Author;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AuthorDaoTest {

    @Test
    public void authorDao() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        AuthorDAO authorDAO = context.getBean("authorDAOImpl", AuthorDAOImpl.class);
        Author author = new Author();
        author.setFirst_name("Dan");
        author.setLast_name("Brown");
        authorDAO.save(author);
        context.close();
    }
}
