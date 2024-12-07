package project.booksLibrary.model;

import jakarta.persistence.*;
import lombok.Data;


import java.time.LocalDateTime;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Book book;

    private String reviewContent;

    private int rating;

    private LocalDateTime createdAt;

    // Getters and setters
}
