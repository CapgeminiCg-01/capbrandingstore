package com.capbranding.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.capbranding.entities.User;
import com.capbranding.exceptions.UserNotFoundException;
import com.capbranding.repositories.LoginRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
@Transactional

public class LoginServiceImpl implements LoginService {
	
	@Autowired(required = true)
	LoginRepository loginRepo;

	Logger logger = LoggerFactory.getLogger(LoginServiceImpl.class);



	@Override
	public User addUser(User user) {
		logger.info("User addUser()");
		if(user == null)
			throw new UserNotFoundException("User Not Found");
		else {
			loginRepo.save(user);
			return user;
		}
	}

	@Override
	public User removeUser(int userId) {
		logger.info("User removeUser()");
		Optional<User> user = loginRepo.findById(userId);
		if(!user.isPresent())
			throw new UserNotFoundException("User Not Found");
		else {
			loginRepo.delete(user.get());
			return user.get();
		}
	}

	@Override
	public User validateUser(int userId) {
		logger.info("User validateUser()");
		String pass = loginRepo.getPassword(userId);
		User u = loginRepo.findValidateUser(userId,pass);
		if(u == null)
			throw new UserNotFoundException("User Not Found");
		else
			return u;
	}

	@Override
	public User signOut(User user) {
		
		return null;
	}

}
