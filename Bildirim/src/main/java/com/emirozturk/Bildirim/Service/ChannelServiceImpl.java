package com.emirozturk.Bildirim.Service;

import com.emirozturk.Bildirim.DAO.ChannelRepository;
import com.emirozturk.Bildirim.Entity.Channel;
import com.emirozturk.Bildirim.Entity.Message;
import com.emirozturk.Bildirim.Entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {
    ChannelRepository channelRepository;

    public ChannelServiceImpl(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    @Override
    public Channel updateChannel(String channelId, Channel channel) {
       return channelRepository.save(channel);
    }

    @Override
    public Channel sendMessageToChannel(Message message, String channelId) {
        var channel = channelRepository.findById(channelId).orElse(null);
        if(channel != null){
            if(channel.getMessages()==null)
                channel.setMessages(new ArrayList<>());
            channel.getMessages().add(message);
            return channelRepository.save(channel);
        }
        else return null;
    }

    @Override
    public Channel removeMessageFromChannel(Message message, String channelId) {
        var channel = channelRepository.findById(channelId).orElse(null);
        if(channel != null){
            var channelMessages = channel.getMessages();
            if(channelMessages!=null)
                channelMessages.removeIf(element->element.getId().equals(message.getId()));
            return channelRepository.save(channel);
        }
        return null;
    }

    @Override
    public Channel addUserToChannel(User user, Channel channel) {
        channel.getUsers().add(user);
        return channelRepository.save(channel);
    }

    @Override
    public List<Channel> getAllChannels() {
        return channelRepository.findAll();
    }

    @Override
    public Channel saveChannel(Channel channel) {
       return channelRepository.save(channel);
    }

    @Override
    public Channel getChannel(String channelId) {
        return channelRepository.findById(channelId).orElse(null);
    }

    @Override
    public Channel addChannel(Channel newChannel) {
        return channelRepository.save(newChannel);
    }

    @Override
    public void deleteChannel(String channelId) {
        channelRepository.deleteById(channelId);
    }

    @Override
    public void removeUserFromChannel(User user, Channel channel) {
        channel.getUsers().removeIf(x-> x.getId().equals(user.getId()));
        channelRepository.save(channel);
    }
}
