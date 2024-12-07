package project.booksLibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.booksLibrary.model.Book;
import project.booksLibrary.repository.BookRepository;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Optional<Book> findBookById(Long id) {
        return bookRepository.findById(id);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
