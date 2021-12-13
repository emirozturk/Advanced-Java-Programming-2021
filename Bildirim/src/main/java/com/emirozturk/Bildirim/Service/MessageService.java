package com.emirozturk.Bildirim.Service;

import com.emirozturk.Bildirim.Entity.Message;

public interface MessageService {
    Message saveMessage(Message message);
    Message findById(String messageId);
}
