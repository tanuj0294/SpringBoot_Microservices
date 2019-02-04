package org.springboot.microservices.learn.microservices.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springboot.microservices.learn.microservices.dto.User;
import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 3;
	
	static {
		users.add(new User(1,"one",new Date()));
		users.add(new User(2,"two",new Date()));
		users.add(new User(3,"three",new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User save(User user) {
		if(user.getId()==null) {
			user.setId(++usersCount);
		}
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for(User u : users) {
			if(u.getId()==id) {
				return u;
			}
		}
		return null;
	}
	
	public User deleteUserById(int id) {
		Iterator<User> itr = users.iterator();
		while(itr.hasNext()) {
			User user = itr.next();
			if(user.getId()==id) {
				itr.remove();
				return user;
			}
		}
		
		return null;
	}
}
