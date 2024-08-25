package com.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Model.otherUsers;
import com.project.Repo.otherUserRepo;

@Service
public class otherUsersService {
	
	@Autowired
	otherUserRepo repo;
	
	
	public void addUser(otherUsers otheruser)
	{
		repo.save(otheruser);
	}
}
