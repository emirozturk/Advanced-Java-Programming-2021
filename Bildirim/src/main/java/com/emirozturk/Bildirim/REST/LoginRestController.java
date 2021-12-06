package com.emirozturk.Bildirim.REST;

import com.emirozturk.Bildirim.Entity.Response;
import com.emirozturk.Bildirim.Entity.User;
import com.emirozturk.Bildirim.Service.LoginService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Login")
public class LoginRestController {
    private LoginService loginService;
    public LoginRestController(LoginService loginService){
        this.loginService = loginService;
    }
    @GetMapping("/CheckLogin")
    public Response<User> checkLogin(String mail,String password) {
        try{
            var result = loginService.checkLogin(mail,password);
            if(result == null)
                return new Response<>(false,"User or password is wrong",null);
            else
                return new Response<>(true,null,result);
        }
        catch(Exception ex){
            return new Response<>(false,ex.getMessage(),null);
        }
    }
}
