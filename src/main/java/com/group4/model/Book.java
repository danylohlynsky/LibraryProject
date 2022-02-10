package com.group4.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    int id;

    @Column(nullable = false)
    String title;

    @Column(nullable = false)
    int available_amount;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "main_author_id", nullable = false)
    private Author main_author;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id"))
    private List<Author> co_authors;
}
