package com.group4.controller;

import com.group4.model.Author;
import com.group4.model.Book;
import com.group4.service.interfaces.AuthorService;
import com.group4.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Controller
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("listBooks", this.bookService.listBook());
        return "list-books";
    }


    @GetMapping(value = "/add")
    public String create(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("author",new Author());
        return "create-book";
    }

    @PostMapping(value = "/add")
    public String create(@Validated @ModelAttribute ("author") Author author, @Validated @ModelAttribute("book") Book book, BindingResult result) {
        if (result.hasErrors()) {
            return "create-book";
        }
        book.setMainAuthor(author);
        authorService.addAuthor(author);
        bookService.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/remove/{id}")
    public RedirectView removeBook(@PathVariable("id") int id) {
        this.bookService.removeBook(id);
        return new RedirectView("/books");
    }

    @GetMapping("update/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", bookService.getBookById(id));
        model.addAttribute("author", bookService.getBookById(id).getMainAuthor());
        return "update-book";
    }
}
