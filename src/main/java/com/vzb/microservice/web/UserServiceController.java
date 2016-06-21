package com.vzb.microservice.web;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RestController;

import com.vzb.microservice.model.User;
import com.vzb.microservice.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserServiceController {
	
	@Autowired
	private UserService userService;
	
	private static final Logger LOG = LoggerFactory.getLogger(UserServiceController.class);
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getUser() {
		LOG.info("Fetching user list");
		if(userService.getUserDetail().isEmpty()){
            return new ResponseEntity<List<User>>(HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity<List<User>>(userService.getUserDetail(), HttpStatus.OK);
    }
	
	
	@RequestMapping(value = "/{userName}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable(value="userName") String userName) {
		LOG.info("Fetching User with user name " + userName);
		this.validateUser(userName);
		return new ResponseEntity<User>(this.userService.getUserDetail(userName), HttpStatus.OK);
	}
	
	
	
	private boolean validateUser(String userName) {
		boolean flag = false;
		if(this.userService.findByUsername(userName))
			flag = true;
		else 
			throw new UserNotFoundException(userName);
		
		return flag;
	}
	

}
