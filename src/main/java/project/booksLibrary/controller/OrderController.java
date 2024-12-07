package project.booksLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import project.booksLibrary.service.OrderService;

@RestController
@RequestMapping("/orders")
//@Tag(name = "Orders", description = "Endpoints for managing orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

//    @Operation(summary = "Return a book")
    @PostMapping("/return/{orderId}")
    public ResponseEntity<String> returnBook(@PathVariable Long orderId) {
        return orderService.returnBook(orderId);
    }

//    @Operation(summary = "Extend rental period")
    @PostMapping("/extend/{orderId}")
    public ResponseEntity<String> extendRental(@PathVariable Long orderId) {
        return orderService.extendRental(orderId);
    }
}
