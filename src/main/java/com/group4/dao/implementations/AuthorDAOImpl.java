package com.group4.dao.implementations;

import com.group4.dao.interfaces.AuthorDAO;
import com.group4.model.Author;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAOImpl extends DAOImpl<Author> implements AuthorDAO {
    public AuthorDAOImpl(LocalSessionFactoryBean localSessionFactoryBean) {
        super(localSessionFactoryBean);
    }

    public Author findByFullName(String[] fullName) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();

            Query query = session.createQuery(
                    "from Author A where A.firstName like :firstname and A.lastName like :lastname"
            );
            query.setParameter("firstname", fullName[0]);
            query.setParameter("lastname", fullName[1]);
            List<Author> authors = query.list();
            Author author = authors.get(0);
            session.getTransaction().commit();
            return author;
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
