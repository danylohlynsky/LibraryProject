package com.group4.dao.interfaces;

import com.group4.model.Book;

import java.util.List;

public interface BookDAO {
    void addBook(Book book);

    void updateBook(Book book);

    void removeBook(int id);

    Book getBookById(int id);

    List<Book> listBooks();

}
