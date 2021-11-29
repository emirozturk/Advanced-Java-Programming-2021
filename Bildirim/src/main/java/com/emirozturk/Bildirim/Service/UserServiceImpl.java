package com.emirozturk.Bildirim.Service;

import com.emirozturk.Bildirim.DAO.ChannelRepository;
import com.emirozturk.Bildirim.DAO.UserRepository;
import com.emirozturk.Bildirim.Entity.Channel;
import com.emirozturk.Bildirim.Entity.Role;
import com.emirozturk.Bildirim.Entity.User;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.Collection;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    ChannelRepository channelRepository;
    public UserServiceImpl(UserRepository userRepository,ChannelRepository channelRepository){
        this.userRepository = userRepository;
        this.channelRepository = channelRepository;
    }
    @Override
    public User getUserByMail(String mail) {
        return userRepository.findByMail(mail);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        var foundUser = userRepository.findByMail(user.getMail());
        if(foundUser!=null){
            foundUser.setName(user.getName());
            foundUser.setPassword(user.getPassword());
            foundUser.setEnabled(user.getEnabled());
            foundUser.setChannels(user.getChannels());
            foundUser.setRoles(user.getRoles());
            userRepository.save(foundUser);
        }
        return foundUser;
    }

    @Override
    public User removeChannelFromUser(Channel channel, User user) {
        user.getChannels().removeIf(element->element.getName().equals(channel.getName()));
        return userRepository.save(user);
        /*
        for(var c:user.getChannels()){
            if(c.getName().equals(channel.getName())){
                user.getChannels().remove(c);
            }
        }
         */
    }

    @Override
    public User addChannelToUser(Channel channel, User user) {
         user.getChannels().add(channel);
         //BURADA VERİTABANINA YAZMA KISMI EKLENECEK
         return user;
    }
}
