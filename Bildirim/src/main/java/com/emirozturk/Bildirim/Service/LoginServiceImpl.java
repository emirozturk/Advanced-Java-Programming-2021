package com.emirozturk.Bildirim.Service;

import com.emirozturk.Bildirim.DAO.UserRepository;
import com.emirozturk.Bildirim.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    UserRepository userRepository;

    public LoginServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User checkLogin(String mail, String password) {
        User user = userRepository.findByMail(mail);
        if(user != null)
            if(user.getPassword().equals(password))
                return user;
        return null;
    }
}
