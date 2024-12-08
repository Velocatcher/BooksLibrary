package project.booksLibrary.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import project.booksLibrary.config.Role;

@Entity
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;

    @Enumerated(EnumType.STRING) // Указывает, что роль должна быть сохранена как строка
    private Role role;

    // Геттеры и сеттеры
}
