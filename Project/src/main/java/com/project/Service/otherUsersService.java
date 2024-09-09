package com.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.Model.Students;
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
	
	public boolean userLogin(String email, String password)
	{
		otherUsers user=repo.findByemail(email);
		   if (user != null && user.getPassword().equals(password)) {
	            return true;
	        }
	        return false;
	}


}
