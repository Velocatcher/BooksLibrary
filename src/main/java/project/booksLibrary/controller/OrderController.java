package project.booksLibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.booksLibrary.dto.OrderDTO;
import project.booksLibrary.service.OrderService;

@RestController
@RequestMapping("/orders")
//@Tag(name = "Orders", description = "Endpoints for managing orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<OrderDTO> placeOrder(@RequestBody OrderDTO orderDTO) {
        OrderDTO createdOrder = orderService.placeOrder(orderDTO);
        return ResponseEntity.ok(createdOrder);
    }
//    @Operation(summary = "Return a book")
public ResponseEntity<String> returnBook(@PathVariable Long orderId) {
    orderService.returnBook(orderId);
    return ResponseEntity.ok("Book returned successfully.");
}
//    @PostMapping("/return/{orderId}")
//    public ResponseEntity<String> returnBook(@PathVariable Long orderId) {
//        return orderService.returnBook(orderId);
//    }

//    @Operation(summary = "Extend rental period")
public ResponseEntity<String> extendRental(@PathVariable Long orderId) {
    orderService.extendRental(orderId);
    return ResponseEntity.ok("Rental period extended successfully.");
}
//    @PostMapping("/extend/{orderId}")
//    public ResponseEntity<String> extendRental(@PathVariable Long orderId) {
//        return orderService.extendRental(orderId);
//    }
}
