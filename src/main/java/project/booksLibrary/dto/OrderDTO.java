package project.booksLibrary.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class OrderDTO {
    private Long id;
    private Long bookId;
    private Long userId;
    private LocalDate dueDate;
    private boolean returned;
}
