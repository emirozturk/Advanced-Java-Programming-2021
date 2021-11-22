package com.emirozturk.Bildirim;

import com.emirozturk.Bildirim.DAO.ChannelRepository;
import com.emirozturk.Bildirim.DAO.UserRepository;
import com.emirozturk.Bildirim.Entity.Channel;
import com.emirozturk.Bildirim.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class BildirimApplication implements CommandLineRunner {
	UserRepository userRepository;
	ChannelRepository channelRepository;
	public BildirimApplication(UserRepository userRepository,ChannelRepository channelRepository){
		this.userRepository = userRepository;
		this.channelRepository = channelRepository;
	}
	public static void main(String[] args) {
		SpringApplication.run(BildirimApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		User yeniKullanici = new User(null,"emirozturk@trakya.edu.tr","Emir Öztürk","123"
				,true,null,null);
		User ikinciKullanici = new User(null,"berdanakbulut@trakya.edu.tr","Berdan Akbulut","1234"
				,true,null,null);
		List<User> users = new ArrayList<>();
		users.add(yeniKullanici);
		users.add(ikinciKullanici);
		userRepository.saveAll(users);
		var result = userRepository.findAll();
		for(var record : result)
			System.out.println(record);
		var result = userRepository.findByMail("emirozturk@trakya.edu.tr");
		System.out.println(result);
		userRepository.delete(result);
				User yeniKullanici = new User(null,"emirozturk@trakya.edu.tr","Emir Öztürk","123"
				,true,null,null);
		userRepository.save(yeniKullanici);
		var result = userRepository.findAll();
		var channel = new Channel(null,"Arıza destek", LocalDateTime.now(),yeniKullanici,result,null);
		channelRepository.save(channel);
		*/
		var user = userRepository.findByMail("emirozturk@trakya.edu.tr");
		var result = channelRepository.findByNameAndOwner("Arıza destek",user);
		System.out.println(result);
	}
}
