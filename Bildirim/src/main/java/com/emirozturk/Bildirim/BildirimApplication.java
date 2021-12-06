package com.emirozturk.Bildirim;

import com.emirozturk.Bildirim.DAO.ChannelRepository;
import com.emirozturk.Bildirim.DAO.UserRepository;
import com.emirozturk.Bildirim.Entity.Channel;
import com.emirozturk.Bildirim.Entity.User;
import com.emirozturk.Bildirim.Service.ChannelService;
import com.emirozturk.Bildirim.Service.LoginService;
import com.emirozturk.Bildirim.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BildirimApplication{
	public static void main(String[] args) {
		SpringApplication.run(BildirimApplication.class, args);
	}
}
