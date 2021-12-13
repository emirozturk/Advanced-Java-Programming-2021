package com.emirozturk.Bildirim.Service;

import com.emirozturk.Bildirim.Entity.Channel;
import com.emirozturk.Bildirim.Entity.Message;
import com.emirozturk.Bildirim.Entity.User;

import java.util.List;

public interface ChannelService {
    Channel updateChannel(String channelId, Channel channel);
    Channel sendMessageToChannel(Message message, String channelId);
    Channel removeMessageFromChannel(Message message, String channelId);
    Channel addUserToChannel(User user, Channel channel);
    List<Channel> getAllChannels();
    Channel saveChannel(Channel channel);
    Channel getChannel(String channelId);
    Channel addChannel(Channel newChannel);
    void deleteChannel(String channelId);

    void removeUserFromChannel(User user, Channel channel);
}
