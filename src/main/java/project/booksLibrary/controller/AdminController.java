package project.booksLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.booksLibrary.repository.BookRepository;

import java.awt.print.Book;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping("/books")
    public Book addBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id) {
        bookRepository.deleteById(id);
    }
}

