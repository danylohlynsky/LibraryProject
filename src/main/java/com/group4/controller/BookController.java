package com.group4.controller;

import com.group4.model.Author;
import com.group4.model.Book;
import com.group4.service.interfaces.AuthorService;
import com.group4.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }



    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String listBooks(Model model) {
        // Test services and dao
        Author author1 = new Author();
        author1.setFirstName("Dan");
        author1.setLastName("Brown");
        authorService.addAuthor(author1);
        Author author2 = new Author();
        author2.setFirstName("Taras");
        author2.setLastName("Shevchenko");
        authorService.addAuthor(author2);
        Book book1 = new Book();
        book1.setTitle("Origin");
        book1.setAvailableAmount(3);
        book1.setMainAuthor(author1);
        bookService.addBook(book1);

        model.addAttribute("book", new Book());
        model.addAttribute("listBooks", this.bookService.listBook());

        return "book-list";
    }

    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    public String addBook(@ModelAttribute("book") Book book) {
        if (book.getId() == 0) {
            this.bookService.addBook(book);
        } else {
            this.bookService.updateBook(book);
        }

        return "/WEB-INF/views/book-list.html";
    }

    @RequestMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id) {
        this.bookService.removeBook(id);

        return "/WEB-INF/views/book-list.html";
    }

    @RequestMapping("edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", this.bookService.getBookById(id));
        model.addAttribute("listBooks", this.bookService.listBook());

        return "/WEB-INF/views/book-list.html";
    }

    @RequestMapping("bookdate/{id}")
    public String bookDate(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", this.bookService.getBookById(id));

        return "bookdate";
    }
}
