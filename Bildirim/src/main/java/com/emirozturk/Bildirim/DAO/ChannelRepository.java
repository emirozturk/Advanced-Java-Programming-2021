package com.emirozturk.Bildirim.DAO;

import com.emirozturk.Bildirim.Entity.Channel;
import com.emirozturk.Bildirim.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChannelRepository extends MongoRepository<Channel,String> {
    Channel deleteByNameAndOwner(String name, User owner);
    Channel findByNameAndOwner(String name,User owner);
}
