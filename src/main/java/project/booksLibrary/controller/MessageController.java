package project.booksLibrary.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.booksLibrary.dto.MessageDTO;
import project.booksLibrary.model.Message;
import project.booksLibrary.service.MessageService;

import java.util.List;

@RestController
@RequestMapping("/messages")
//@Tag(name = "Messages", description = "Endpoints for managing messages between users and administrators")
public class MessageController {

    @Autowired
    private MessageService messageService;

//    @Operation(summary = "Get all messages for a user")
    @GetMapping("/{userId}")
    public List<Message> getMessagesForUser(@PathVariable Long userId) {
        return messageService.getMessagesForUser(userId);
    }

//    @Operation(summary = "Send a new message")
    @PostMapping("/send")
    public Message sendMessage(@RequestBody MessageDTO messageDTO) {
        return messageService.sendMessage(
            messageDTO.getSenderId(),
            messageDTO.getReceiverId(),
            messageDTO.getContent()
        );
    }
}
