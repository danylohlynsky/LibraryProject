package com.group4.dao.implementations;

import com.group4.dao.interfaces.BookDAO;
import com.group4.dao.interfaces.DAO;
import com.group4.model.Book;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BookDAOImpl extends DAOImpl<Book> implements BookDAO {
    public BookDAOImpl(LocalSessionFactoryBean localSessionFactoryBean) {
        super(localSessionFactoryBean);
    }

    @Override
    public void deleteBook(Book book) {
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            Query query = session.createQuery(
                    "delete Book where id = :bookId"
            );
            query.setParameter("bookId", book.getId());
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            e.printStackTrace();
            System.out.println("Error performing JPA operation. Transaction is rolled back");
        } finally {
            session.close();
        }
    }

    public List<Book> findAll() {
        return super.findAll(Book.class);
    }
}
