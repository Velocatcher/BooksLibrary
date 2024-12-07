package project.booksLibrary.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageDTO {
    private Long senderId;
    private Long receiverId;
    private String content;
}
