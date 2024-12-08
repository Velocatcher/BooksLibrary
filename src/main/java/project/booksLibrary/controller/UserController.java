package project.booksLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.booksLibrary.dto.ReviewDTO;
import project.booksLibrary.dto.UserDTO;
import project.booksLibrary.model.Review;
import project.booksLibrary.repository.BookRepository;
import project.booksLibrary.service.OrderService;
import project.booksLibrary.service.ReviewService;

import project.booksLibrary.model.Book;
import project.booksLibrary.service.UserService;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Регистрация нового пользователя
    @PostMapping("/register")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        UserDTO createdUser = userService.saveUser(userDTO);
        return ResponseEntity.ok(createdUser);
    }

    // Получение информации о пользователе по ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUser(@PathVariable Long id) {
        UserDTO userDTO = userService.getUserById(id);
        return ResponseEntity.ok(userDTO);
    }

    // Получение списка всех пользователей
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userService.getAllUsers();
    }

    // Обновление информации о пользователе
    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> updateUser(@PathVariable Long id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.updateUser(id, userDTO);
        return ResponseEntity.ok(updatedUser);
    }

    // Удаление пользователя по ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully.");
    }
}

//
//@RestController
//@RequestMapping("/user")
////@Tag(name = "User", description = "Endpoints for user actions")
//public class UserController {
//
//    @Autowired
//    private BookRepository bookRepository;
//
//    @Autowired
//    private OrderService orderService;
//
//    @Autowired
//    private ReviewService reviewService;
//
////    @Operation(summary = "List all books")
//    @GetMapping("/books")
//    public List<Book> listBooks() {
//        return bookRepository.findAll();
//    }
//
////    @Operation(summary = "Order a book")
//    @PostMapping("/order/{bookId}")
//    public ResponseEntity<String> orderBook(@PathVariable Long bookId, Principal principal) {
//        return orderService.placeOrder(bookId, principal.getName());
//    }
//
////    @Operation(summary = "Write a review for a book")
//    @PostMapping("/review/{bookId}")
//    public ResponseEntity<Review> writeReview(
//            @PathVariable Long bookId,
//            @RequestBody ReviewDTO reviewDTO,
//            Principal principal) {
//        Review review = reviewService.addReview(principal.getName(), bookId, reviewDTO.getReviewContent(), reviewDTO.getRating());
//        return ResponseEntity.ok(review);
//    }
//}
