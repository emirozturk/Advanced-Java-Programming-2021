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
public class BildirimApplication implements CommandLineRunner {
	private final UserService userService;
	private final LoginService loginService;
	private final ChannelService channelService;
	public BildirimApplication(UserService userService,LoginService loginService,ChannelService channelService){
		this.userService = userService;
		this.loginService = loginService;
		this.channelService = channelService;
	}
	public static void main(String[] args) {
		SpringApplication.run(BildirimApplication.class, args);
	}

	void printList(List list){
		for(var element:list)
			System.out.println(element);
	}
	@Override
	public void run(String... args) throws Exception {
		var user = loginService.checkLogin("emirozturk@trakya.edu.tr","123");
		var channel = channelService.getAllChannels().get(0);
		var newUser = userService.addChannelToUser(channel,user);
		System.out.println(newUser);
		var userFromDb = userService.getUserByMail("emirozturk@trakya.edu.tr");
		System.out.println(userFromDb);
	}
}
