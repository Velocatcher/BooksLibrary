package project.booksLibrary.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.Expression;
import jakarta.persistence.criteria.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.booksLibrary.repository.BookRepository;
import project.booksLibrary.repository.OrderRepository;
import project.booksLibrary.repository.UserRepository;

import java.awt.print.Book;
import java.time.LocalDate;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> placeOrder(Long bookId, String username) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book not found"));

        if (!book.isAvailable()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Book is not available for order.");
        }

        Order order = new Order() {
            @Override
            public Order reverse() {
                return null;
            }

            @Override
            public boolean isAscending() {
                return false;
            }

            @Override
            public Expression<?> getExpression() {
                return null;
            }
        };
        order.setUser(user);
        order.setBook(book);
        order.setDueDate(LocalDate.now().plusWeeks(2));
        order.setReturned(false);
        orderRepository.save(order);

        book.setAvailable(false);
        bookRepository.save(book);

        return ResponseEntity.ok("Order placed successfully.");
    }

    public ResponseEntity<String> returnBook(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new EntityNotFoundException("Order not found"));

        if (order.isReturned()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Order is already returned.");
        }

        order.setReturned(true);
        order.getBook().setAvailable(true);
        orderRepository.save(order);
        bookRepository.save(order.getBook());

        return ResponseEntity.ok("Book returned successfully.");
    }

    public ResponseEntity<String> extendRental(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() -> new EntityNotFoundException("Order not found"));

        if (order.isReturned()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot extend a returned order.");
        }

        order.setDueDate(order.getDueDate().plusWeeks(1));
        orderRepository.save(order);

        return ResponseEntity.ok("Rental period extended successfully.");
    }
}
