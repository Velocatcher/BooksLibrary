package project.booksLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.booksLibrary.dto.ReviewDTO;
import project.booksLibrary.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/reviews")
//@Tag(name = "Reviews", description = "Endpoints for managing reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<ReviewDTO> addReview(@RequestBody ReviewDTO reviewDTO) {
        ReviewDTO createdReview = reviewService.addReview(reviewDTO);
        return ResponseEntity.ok(createdReview);
    }

    @GetMapping("/{bookId}")
    public List<ReviewDTO> getReviewsByBook(@PathVariable Long bookId) {
        return reviewService.getReviewsByBookId(bookId);
    }
}
