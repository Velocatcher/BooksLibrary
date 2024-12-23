package project.booksLibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.booksLibrary.dto.BookDTO;
import project.booksLibrary.model.Book;
import project.booksLibrary.repository.BookRepository;

import java.util.List;

import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<BookDTO> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(book -> new BookDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getDescription(), book.isAvailable()))
                .collect(Collectors.toList());
    }

    public BookDTO saveBook(BookDTO bookDTO) {
        Book book = new Book();
        book.setTitle(bookDTO.getTitle());
        book.setAuthor(bookDTO.getAuthor());
        book.setDescription(bookDTO.getDescription());
        book.setAvailable(bookDTO.isAvailable());
        Book savedBook = bookRepository.save(book);
        return new BookDTO(savedBook.getId(), savedBook.getTitle(), savedBook.getAuthor(), savedBook.getDescription(), savedBook.isAvailable());
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }
}
