package project.booksLibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class ReviewDTO {
    private Long id;
    private Long bookId;
    private Long userId;
    private String reviewContent;
    private int rating;
    private LocalDateTime createdAt;
}
