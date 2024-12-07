package project.booksLibrary.model;

import jakarta.persistence.*;
import lombok.Data;
import project.booksLibrary.model.User;
import java.time.LocalDateTime;

@Entity
@Data

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User sender;

    @ManyToOne
    private User receiver;

    private String content;

    private LocalDateTime timestamp;

    private boolean read;

    // Getters and setters
}
