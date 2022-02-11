package com.group4.service.implementations;

import com.group4.dao.interfaces.BookDAO;
import com.group4.model.Book;
import com.group4.service.interfaces.BookService;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Setter
public class BookServiceImpl implements BookService {
    private BookDAO bookDao;

    @Autowired
    public BookServiceImpl(BookDAO bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    @Transactional
    public void addBook(Book book) {
        this.bookDao.save(book);
    }

    @Override
    @Transactional
    public void updateBook(Book book) {
        this.bookDao.update(book);
    }

    @Override
    @Transactional
    public void removeBook(int id) {
        this.bookDao.deleteById(id, Book.class);

    }

    @Override
    @Transactional
    public Book getBookById(int id) {
        return (Book) this.bookDao.findById(id, Book.class);
    }

    @Override
    @Transactional
    public List<Book> listBook() {
        return this.bookDao.findAll(Book.class);
    }
}
