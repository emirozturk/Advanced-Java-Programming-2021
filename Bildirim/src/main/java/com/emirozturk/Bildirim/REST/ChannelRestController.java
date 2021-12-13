package com.emirozturk.Bildirim.REST;

import com.emirozturk.Bildirim.Entity.Channel;
import com.emirozturk.Bildirim.Entity.Response;
import com.emirozturk.Bildirim.Entity.User;
import com.emirozturk.Bildirim.Service.ChannelService;
import com.emirozturk.Bildirim.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Channels")
public class ChannelRestController {
    private ChannelService channelService;
    private UserService userService;
    public ChannelRestController(ChannelService channelService,UserService userService){
        this.channelService = channelService;
        this.userService = userService;
    }
    @GetMapping("/")
    Response<List<Channel>> getChannels(){
        try{
            return new Response<>(true,null,channelService.getAllChannels());
        }
        catch (Exception ex){
            return new Response<>(false,ex.getMessage(),null);
        }
    }
    @GetMapping("/Channel/{channelId}")
    Response<Channel> getChannel(@PathVariable String channelId){
        try{
            var channel =channelService.getChannel(channelId);
            return new Response<>(true,null,channel);
        }
        catch (Exception ex){
            return new Response<>(false,ex.getMessage(),null);
        }
    }
    @PostMapping("/")
    Response<Channel> addChannel(@RequestBody Channel newChannel){
        try{
            return new Response<>(true,null,channelService.addChannel(newChannel));
        }
        catch (Exception ex){
            return new Response<>(false,ex.getMessage(),null);
        }

    }
    @PutMapping("/Channel/{channelId}")
    Response<Channel> updateChannel(@RequestBody Channel newChannel,@PathVariable String channelId){
        try{
            return new Response<Channel>(true,null,channelService.updateChannel(channelId,newChannel));
        }
        catch (Exception ex){
            return new Response<>(false,ex.getMessage(),null);
        }

    }
    @DeleteMapping("/Channel/{channelId}")
    Response<Boolean> deleteChannel(@PathVariable String channelId){
        try{
            channelService.deleteChannel(channelId);
            return new Response<Boolean>(true,null,true);
        }
        catch (Exception ex){
            return new Response<>(false,ex.getMessage(),null);
        }

    }
    @GetMapping("/User/{userId}/Channel/{channelId}")
    Response<Channel> addUserToChannel(String userId,String channelId){
        try{
            User user = userService.findById(userId);
            Channel channel = channelService.getChannel(channelId);
            return new Response<>(true,null,channelService.addUserToChannel(user,channel));
        }
        catch (Exception ex){
            return new Response<>(false,ex.getMessage(),null);
        }

    }
    @DeleteMapping("/User/{userId}/Channel/{channelId}")
    Response<Boolean> deleteUserFromChannel(String userId,String channelId){
        try{
            User user = userService.findById(userId);
            Channel channel = channelService.getChannel(channelId);
            channelService.removeUserFromChannel(user,channel);
            return new Response<>(true,null,true);
        }
        catch (Exception ex){
            return new Response<>(false,ex.getMessage(),null);
        }
    }
}
