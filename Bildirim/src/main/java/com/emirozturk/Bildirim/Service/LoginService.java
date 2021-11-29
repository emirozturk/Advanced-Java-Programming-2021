package com.emirozturk.Bildirim.Service;

import com.emirozturk.Bildirim.Entity.User;

public interface LoginService {
    User checkLogin(String mail,String password);
}
