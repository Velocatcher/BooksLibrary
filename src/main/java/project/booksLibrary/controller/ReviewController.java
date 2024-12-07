package project.booksLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.booksLibrary.model.Review;
import project.booksLibrary.service.ReviewService;

import java.util.List;

@RestController
@RequestMapping("/reviews")
//@Tag(name = "Reviews", description = "Endpoints for managing reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

//    @Operation(summary = "Get all reviews for a book")
    @GetMapping("/{bookId}")
    public List<Review> getReviewsByBook(@PathVariable Long bookId) {
        return reviewService.getReviewsByBookId(bookId);
    }
}
