package com.group4.controller;

import com.group4.model.Author;
import com.group4.model.Book;
import com.group4.service.interfaces.AuthorService;
import com.group4.service.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class BookController {

    private final BookService bookService;
    private final AuthorService authorService;

    @Autowired
    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping(value = "/books")
    public String listBooks(Model model) {
        model.addAttribute("listBooks", this.bookService.listBook());
        return "book-list";
    }


    @RequestMapping(value = "/books/add", method = RequestMethod.GET)
    public String toAddPage() {
        return "add-book";
    }


    @RequestMapping(value = "/books/add", method = RequestMethod.POST)
    @ResponseBody
    public RedirectView  addBook(@RequestParam String title, @RequestParam String authorFullName, @RequestParam String availableAmount) {
        Book newBook = new Book();
        newBook.setTitle(title);
        newBook.setAvailableAmount(Integer.parseInt(availableAmount));
        String[] nameSurName = authorFullName.split(" ");
        Author author = authorService.getAuthorByFullName(nameSurName);
        if(author != null) {
            newBook.setMainAuthor(author);
        } else {
            author = new Author();
            author.setFirstName(nameSurName[0]);
            author.setLastName(nameSurName[1]);
            authorService.addAuthor(author);
            newBook.setMainAuthor(author);
        }
        this.bookService.addBook(newBook);
        return new RedirectView("/books");
    }

    @RequestMapping("/remove-book/{id}")
    public RedirectView removeBook(@PathVariable("id") int id) {
        this.bookService.removeBook(id);

        return new RedirectView("/books");
    }

    @RequestMapping("edit/{id}")
    public String editBook(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", this.bookService.getBookById(id));
        model.addAttribute("listBooks", this.bookService.listBook());

        return "book-list";
    }

    @RequestMapping("bookdate/{id}")
    public String bookDate(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", this.bookService.getBookById(id));

        return "bookdate";
    }


}
