package com.emirozturk.Bildirim.Service;

import com.emirozturk.Bildirim.Entity.Channel;
import com.emirozturk.Bildirim.Entity.User;

import java.util.List;

public interface UserService {
    User getUserByMail(String mail);
    List<User> getAllUsers();
    User saveUser(User user);
    User updateUser(User user);
    User removeChannelFromUser(Channel channel, User user);
    User addChannelToUser(Channel channel,User user);
    String deleteUser(String mail);
}
