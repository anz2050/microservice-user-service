package com.vzb.microservice.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.vzb.microservice.model.User;

@Component
public class UserService {
	
	private final AtomicLong counter = new AtomicLong();

	public List<User> getUserDetail() {
		User user1 = new User(counter.incrementAndGet(), "John");
		User user2 = new User(counter.incrementAndGet(), "Adam");
		User user3 = new User(counter.incrementAndGet(), "Navin");
		User user4 = new User(counter.incrementAndGet(), "Eric");
		User user5 = new User(counter.incrementAndGet(), "Vijai");
		
		List<User> userList = new ArrayList<>();
		userList.add(user1);
		userList.add(user2);
		userList.add(user3);
		userList.add(user4);
		userList.add(user5);
		
		return userList;
	}
	

	public User getUserDetail(String userName) {
		List<User> userList = getUserDetail();
		User user = null;
		Iterator<User> it = userList.iterator();
		while(it.hasNext()) {
			user = it.next();
			if(user.getUserName().equalsIgnoreCase(userName)) 
				return user;
		}
 		return user;
	}
	
	public boolean findByUsername(String userName) {
		User user = getUserDetail(userName);
		if(user == null)
			return false;
		else
			return true;
	}


}
