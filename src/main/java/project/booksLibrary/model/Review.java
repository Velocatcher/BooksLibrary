package project.booksLibrary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "review_content", nullable = false)
    private String reviewContent;

    @Column(name = "rating", nullable = false)
    private int rating;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    /**
     * Метод для получения ID пользователя
     * @return ID пользователя или null, если user равен null
     */
    public Long getUserId() {
        return user != null ? user.getId() : null;
    }

    /**
     * Метод для установки ID пользователя
     * @param userId ID пользователя
     */
    public void setUserId(Long userId) {
        if (this.user == null) {
            this.user = new User();
        }
        this.user.setId(userId);
    }

    /**
     * Метод для получения ID книги
     * @return ID книги или null, если book равен null
     */
    public Long getBookId() {
        return book != null ? book.getId() : null;
    }

    /**
     * Метод для установки ID книги
     * @param bookId ID книги
     */
    public void setBookId(Long bookId) {
        if (this.book == null) {
            this.book = new Book();
        }
        this.book.setId(bookId);
    }
}
