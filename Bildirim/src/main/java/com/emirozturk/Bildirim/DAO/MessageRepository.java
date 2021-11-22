package com.emirozturk.Bildirim.DAO;

import com.emirozturk.Bildirim.Entity.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message,String> {
}
