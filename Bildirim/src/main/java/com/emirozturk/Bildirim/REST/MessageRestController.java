package com.emirozturk.Bildirim.REST;

import com.emirozturk.Bildirim.Entity.Message;
import com.emirozturk.Bildirim.Entity.Response;
import com.emirozturk.Bildirim.Service.ChannelService;
import com.emirozturk.Bildirim.Service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Messages")
public class MessageRestController {
    private MessageService messageService;
    private ChannelService channelService;
    public MessageRestController(MessageService messageService,ChannelService channelService){
        this.messageService = messageService;
        this.channelService = channelService;
    }
    @PostMapping("/AddMessageToChannel/{channelId}")
    Response<Message> addMessageToChannel(@PathVariable String channelId,@RequestBody Message message){
        try{
            var newMessage = messageService.saveMessage(message);
            var result = channelService.sendMessageToChannel(newMessage,channelId);
            return new Response<>(true,null,newMessage);
        }
        catch (Exception ex) {
            return new Response<>(false,ex.getMessage(),null);
        }
    }
    @DeleteMapping("/DeleteMessage/{messageId}/FromChannel{channelId}")
    Response<Boolean> removeMessageFromChannel(@PathVariable String channelId,@PathVariable String messageId){
        try{
            Message message = messageService.findById(messageId);
            channelService.removeMessageFromChannel(message,channelId);
            return new Response<>(true,null,true);
        }
        catch(Exception ex) {
            return new Response<>(false, ex.getMessage(), null);
        }
    }
}
