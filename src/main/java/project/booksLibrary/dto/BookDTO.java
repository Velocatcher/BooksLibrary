package project.booksLibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class BookDTO {
    private Long id;
    private String title;
    private String author;
    private String description;
    private boolean available;
}