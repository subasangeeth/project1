package com.project.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Model.Students;

@Repository
public interface StudentRepo  extends JpaRepository<Students,String>{
	  

	Students findByrollno(String rollno);
}
