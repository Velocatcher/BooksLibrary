package project.booksLibrary.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.booksLibrary.dto.MessageDTO;
import project.booksLibrary.model.Message;
import project.booksLibrary.repository.MessageRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public List<MessageDTO> getMessagesForUser(Long userId) {
        return messageRepository.findByReceiverId(userId).stream()
                .map(message -> new MessageDTO(message.getId(), message.getSenderId(), message.getReceiverId(), message.getContent(), message.getTimestamp(), message.isRead()))
                .collect(Collectors.toList());
    }

    public MessageDTO sendMessage(MessageDTO messageDTO) {
        Message message = new Message();
        message.setSenderId(messageDTO.getSenderId());
        message.setReceiverId(messageDTO.getReceiverId());
        message.setContent(messageDTO.getContent());
        message.setTimestamp(messageDTO.getTimestamp());
        message.setRead(messageDTO.isRead());
        Message savedMessage = messageRepository.save(message);
        return new MessageDTO(savedMessage.getId(), savedMessage.getSenderId(), savedMessage.getReceiverId(), savedMessage.getContent(), savedMessage.getTimestamp(), savedMessage.isRead());
    }
}
