package com.project.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.Model.Students;
import com.project.Repo.StudentRepo;

@Service
public class studentService {
	
	@Autowired
	StudentRepo repo;
	
	public studentService(StudentRepo repo) {

		super();
		this.repo = repo;
	}


	public Students addStudent(Students students)
	{

		return repo.save(students);

	}
	



	public boolean StudentLogin(String rollno, String password)
	{
		Students student=repo.findByrollno(rollno);

		   if (student != null && student.getPassword().equals(password)) {

	            return true;

	        }
	        return false;
	}
	
	

	
	
}
