package com.emirozturk.Bildirim.Service;

import com.emirozturk.Bildirim.DAO.ChannelRepository;
import com.emirozturk.Bildirim.Entity.Channel;
import com.emirozturk.Bildirim.Entity.Message;
import com.emirozturk.Bildirim.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChannelServiceImpl implements ChannelService {
    ChannelRepository channelRepository;

    public ChannelServiceImpl(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    @Override
    public Channel updateChannel(Channel channel) {
       return channelRepository.save(channel);
    }

    @Override
    public Channel sendMessageToChannel(Message message, Channel channel) {
        channel.getMessages().add(message);
        return channelRepository.save(channel);
    }

    @Override
    public Channel removeMessageFromChannel(Message message, Channel channel) {
        channel.getMessages().removeIf(element->element.getId().equals(message.getId()));
        return channelRepository.save(channel);
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
}
