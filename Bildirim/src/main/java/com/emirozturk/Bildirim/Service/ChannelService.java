package com.emirozturk.Bildirim.Service;

import com.emirozturk.Bildirim.Entity.Channel;
import com.emirozturk.Bildirim.Entity.Message;
import com.emirozturk.Bildirim.Entity.User;

import java.util.List;

public interface ChannelService {
    Channel updateChannel(Channel channel);
    Channel sendMessageToChannel(Message message, Channel channel);
    Channel removeMessageFromChannel(Message message, Channel channel);
    Channel addUserToChannel(User user, Channel channel);
    List<Channel> getAllChannels();
    Channel saveChannel(Channel channel);
}
