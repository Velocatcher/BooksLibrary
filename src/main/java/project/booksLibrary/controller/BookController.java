package project.booksLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.booksLibrary.model.Book;
import project.booksLibrary.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/books")
//@Tag(name = "Books", description = "Endpoints for managing books")
public class BookController {

    @Autowired
    private BookService bookService;

//    @Operation(summary = "Get all books")
    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

//    @Operation(summary = "Add a new book")
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

//    @Operation(summary = "Delete a book by ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.ok("Book deleted successfully.");
    }
}
