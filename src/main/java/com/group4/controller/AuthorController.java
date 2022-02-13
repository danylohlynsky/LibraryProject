package com.group4.controller;

import com.group4.service.interfaces.AuthorService;
import com.group4.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/authors")
public class AuthorController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public AuthorController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("listAuthor", this.authorService.listAuthor());
        return "list-author";
    }

    @GetMapping("/remove/{id}")
    public RedirectView removeBook(@PathVariable("id") int id) {
        this.authorService.removeAuthor(id);
        return new RedirectView("/authors");
    }
}
