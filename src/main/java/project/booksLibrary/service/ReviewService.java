package project.booksLibrary.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.booksLibrary.model.Book;
import project.booksLibrary.model.Review;
import project.booksLibrary.model.User;
import project.booksLibrary.repository.BookRepository;
import project.booksLibrary.repository.ReviewRepository;
import project.booksLibrary.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    @Autowired
    public ReviewService(ReviewRepository reviewRepository, UserRepository userRepository, BookRepository bookRepository) {
        this.reviewRepository = reviewRepository;
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public Review addReview(String username, Long bookId, String content, int rating) {
        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new EntityNotFoundException("Book not found"));

        Review review = new Review();
        review.setUser(user);
        review.setBook(book);
        review.setReviewContent(content);
        review.setRating(rating);
        review.setCreatedAt(LocalDateTime.now());

        return reviewRepository.save(review);
    }

    public List<Review> getReviewsByBookId(Long bookId) {
        return reviewRepository.findByBookId(bookId);
    }
}
