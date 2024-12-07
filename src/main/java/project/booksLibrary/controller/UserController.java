package project.booksLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.booksLibrary.dto.ReviewDTO;
import project.booksLibrary.model.Review;
import project.booksLibrary.repository.BookRepository;
import project.booksLibrary.service.OrderService;
import project.booksLibrary.service.ReviewService;

import java.awt.print.Book;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/user")
//@Tag(name = "User", description = "Endpoints for user actions")
public class UserController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private OrderService orderService;

    @Autowired
    private ReviewService reviewService;

//    @Operation(summary = "List all books")
    @GetMapping("/books")
    public List<Book> listBooks() {
        return bookRepository.findAll();
    }

//    @Operation(summary = "Order a book")
    @PostMapping("/order/{bookId}")
    public ResponseEntity<String> orderBook(@PathVariable Long bookId, Principal principal) {
        return orderService.placeOrder(bookId, principal.getName());
    }

//    @Operation(summary = "Write a review for a book")
    @PostMapping("/review/{bookId}")
    public ResponseEntity<Review> writeReview(
            @PathVariable Long bookId,
            @RequestBody ReviewDTO reviewDTO,
            Principal principal) {
        Review review = reviewService.addReview(principal.getName(), bookId, reviewDTO.getReviewContent(), reviewDTO.getRating());
        return ResponseEntity.ok(review);
    }
}
