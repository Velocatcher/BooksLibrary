package project.booksLibrary.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import project.booksLibrary.dto.ReviewDTO;
import project.booksLibrary.model.Book;
import project.booksLibrary.model.Review;
import project.booksLibrary.model.User;
import project.booksLibrary.repository.BookRepository;
import project.booksLibrary.repository.ReviewRepository;
import project.booksLibrary.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public ReviewDTO addReview(ReviewDTO reviewDTO) {
        Review review = new Review();
        review.setBookId(reviewDTO.getBookId());
        review.setUserId(reviewDTO.getUserId());
        review.setReviewContent(reviewDTO.getReviewContent());
        review.setRating(reviewDTO.getRating());
        review.setCreatedAt(reviewDTO.getCreatedAt());
        Review savedReview = reviewRepository.save(review);
        return new ReviewDTO(savedReview.getId(), savedReview.getBookId(), savedReview.getUserId(), savedReview.getReviewContent(), savedReview.getRating(), savedReview.getCreatedAt());
    }

    public List<ReviewDTO> getReviewsByBookId(Long bookId) {
        return reviewRepository.findByBookId(bookId).stream()
                .map(review -> new ReviewDTO(review.getId(), review.getBookId(), review.getUserId(), review.getReviewContent(), review.getRating(), review.getCreatedAt()))
                .collect(Collectors.toList());
    }
}
