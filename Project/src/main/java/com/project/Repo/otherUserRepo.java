package com.project.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Model.otherUsers;
 @Repository
public interface otherUserRepo extends JpaRepository<otherUsers, String> {

	otherUsers findByemail(String email);

}
