package com.group4.dao.interfaces;

import com.group4.model.Author;

public interface AuthorDAO extends DAO<Author> {
    Author findByFullName(String[] fullName);

    void deleteAuthor(Author author);
}
