package com.emirozturk.Bildirim.Service;

import com.emirozturk.Bildirim.DAO.MessageRepository;
import com.emirozturk.Bildirim.Entity.Message;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
    MessageRepository messageRepository;
    public MessageServiceImpl(MessageRepository messageRepository){
        this.messageRepository = messageRepository;
    }
    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }
}
