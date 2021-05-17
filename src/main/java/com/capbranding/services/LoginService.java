package com.capbranding.services;

import com.capbranding.entities.User;

public interface LoginService {
	
public User addUser(User user);
	
	public User removeUser(int userId);
	
	public User validateUser(int  userId);
	
	public User signOut(User user);

}
