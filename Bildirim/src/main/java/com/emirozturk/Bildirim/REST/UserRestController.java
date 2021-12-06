package com.emirozturk.Bildirim.REST;

import com.emirozturk.Bildirim.Entity.Response;
import com.emirozturk.Bildirim.Entity.User;
import com.emirozturk.Bildirim.Service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/Users")
public class UserRestController {
    private UserService userService;
    public UserRestController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/")
    public Response<List<User>> getAllUsers(){
        try{
            var users = userService.getAllUsers();
            if(users==null || users.size()==0)
                return new Response<>(false,"No users found",null);
        return new Response<>(true,null,users);
        }
        catch (Exception ex){
            return new Response<>(false,ex.getMessage(),null);
        }
    }
    @GetMapping("/{mail}")
    public Response<User> getUserByMail(@PathVariable String mail){
        try{
            var user = userService.getUserByMail(mail);
            if(user!=null)
                return new Response<>(true,null,user);
            else
                return new Response<>(false,"User not found",null);
        }
        catch(Exception ex)
        {
            return new Response<>(false,ex.getMessage(),null);
        }
    }
    @PostMapping("/")
    public Response<User> saveUser(@RequestBody User user){
        try{
            var response = userService.saveUser(user);
            return new Response<>(true,null,response);
        }catch(Exception ex)
        {
            return new Response<>(false,ex.getMessage(),null);
        }
    }
    @PutMapping ("/{mail}")
    public Response<User> updateUser(@PathVariable String mail, @RequestBody User user){
        try{
            user.setMail(mail);
            var result = userService.updateUser(user);
            return new Response<>(true,null,result);
        }catch(Exception ex){
            return new Response<>(false,ex.getMessage(),null);
        }
    }
    @DeleteMapping("/{mail}")
    public Response<Boolean> deleteUser(@PathVariable String mail){
        var result = userService.deleteUser(mail);
        if(Objects.equals(result, "Success"))
            return new Response<>(true,"Deleted Successfully",true);
        else
            return new Response<>(false,result,false);
    }
    /*
    User removeChannelFromUser(Channel channel, User user);
    User addChannelToUser(Channel channel,User user);
     */
}
