package com.msnks.solr.api.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.msnks.solr.api.model.User;
import com.msnks.solr.api.repository.UserRepository;

@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@PostConstruct
	public void addUser() {
		
		User user1 = new User(123,"김태일", new String[] {"test","한글1"} );
		User user2 = new User(132,"김태이", new String[] {"test","한글2"} );
		User user3 = new User(134,"김태삼", new String[] {"test","한글3"} );
		
		List<User> list = new ArrayList<>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		
		userRepository.saveAll(list);
	}
	
	@GetMapping("/getAllUsers")
	public Iterable<User> getAllUsers(){		
		return userRepository.findAll();
	}
	
	@GetMapping("/getUser/{name}")
	public User getUserByName(@PathVariable String name) {
		return userRepository.findByName(name);
		
	}

}
