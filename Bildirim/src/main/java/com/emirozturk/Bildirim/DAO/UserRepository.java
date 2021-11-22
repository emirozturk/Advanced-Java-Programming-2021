package com.emirozturk.Bildirim.DAO;

import com.emirozturk.Bildirim.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
    User findByMail(String mail);
}
