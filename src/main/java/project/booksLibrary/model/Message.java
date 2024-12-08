package project.booksLibrary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id", nullable = false)
    private User sender;

    @ManyToOne
    @JoinColumn(name = "receiver_id", nullable = false)
    private User receiver;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "timestamp", columnDefinition = "DATETIME", nullable = false)
    private LocalDateTime timestamp;

    @Column(name = "is_read", nullable = false)
    private boolean read;

    /**
     * Метод для получения ID отправителя
     * @return ID отправителя или null, если sender равен null
     */
    public Long getSenderId() {
        return sender != null ? sender.getId() : null;
    }

    /**
     * Метод для получения ID получателя
     * @return ID получателя или null, если receiver равен null
     */
    public Long getReceiverId() {
        return receiver != null ? receiver.getId() : null;
    }

    /**
     * Метод для установки ID отправителя
     * @param senderId ID отправителя
     */
    public void setSenderId(Long senderId) {
        if (this.sender == null) {
            this.sender = new User();
        }
        this.sender.setId(senderId);
    }

    /**
     * Метод для установки ID получателя
     * @param receiverId ID получателя
     */
    public void setReceiverId(Long receiverId) {
        if (this.receiver == null) {
            this.receiver = new User();
        }
        this.receiver.setId(receiverId);
    }
}
