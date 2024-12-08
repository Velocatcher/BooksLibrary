package project.booksLibrary.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.booksLibrary.dto.BookDTO;
import project.booksLibrary.model.Book;
import project.booksLibrary.repository.BookRepository;

@Service
public class AdminService {

    @Autowired
    private BookRepository bookRepository;

    public BookDTO addBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setDescription(bookDTO.getDescription());
        book.setAvailable(bookDTO.isAvailable());
        Book savedBook = bookRepository.save(book);
        return new BookDTO(savedBook.getId(), savedBook.getTitle(), savedBook.getAuthor(), savedBook.getDescription(), savedBook.isAvailable());
    }

    public BookDTO updateBook(Long id, BookDTO bookDTO) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Book not found"));
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setDescription(bookDTO.getDescription());
        book.setAvailable(bookDTO.isAvailable());
        Book updatedBook = bookRepository.save(book);
        return new BookDTO(updatedBook.getId(), updatedBook.getTitle(), updatedBook.getAuthor(), updatedBook.getDescription(), updatedBook.isAvailable());
    }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
