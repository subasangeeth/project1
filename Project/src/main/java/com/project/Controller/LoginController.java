package com.project.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.Model.Students;
import com.project.Model.otherUsers;
import com.project.Service.otherUsersService;
import com.project.Service.studentService;
import com.project.utils.OTPverify;

@Controller
public class LoginController {
	
	@Autowired
	studentService studentservice;
	@Autowired
	otherUsersService otheruserservice;
	@Autowired
	OTPverify otpverify;
	 otherUsers user=new otherUsers();
	 String otpv;
	
	
	@GetMapping("/")
	public String Login()
	{
		return "student.html";
	}
	
	
	@GetMapping("/student")
	public String studetLogin(@RequestParam String rollno, @RequestParam String password)
	{	
		boolean o =studentservice.StudentLogin(rollno, password);
	 
	if(o==true)
		return "Home.html";
	 	else
		return "student.html";
	}
	

	@PostMapping("/newstudent")
	public String addStudent(@RequestParam String rollno, @RequestParam String name, @RequestParam String password) {
	  
		Students students = new Students(rollno, name, password,"Student");
	   
		studentservice.addStudent(students);
	   
		return "Home.html";
	}
	
	
	@GetMapping("/user")
	public String guestLogin(@RequestParam String email, @RequestParam String password)
	{	
		boolean o =otheruserservice.userLogin(email, password);
	 
	if(o==true)
		return "Home.html";
	 	else
		return "guest.html";
	}
	
	
	
	  @GetMapping("/newUser")
	    public String addUser(@RequestParam String otp) {
			if(otpv.equals(otp))
			{
			otheruserservice.addUser(user);
			 return "Home.html";
			}
			else
			{
				return "newGuest.html";
			}
	      
	    }

	
	
	//OTP VERIFY
	  @PostMapping("/send-otp")
	    @ResponseBody
	    public String sendOTP(@RequestBody Map<String, String> payload) {
		  
		 user.setEmail(payload.get("email"));
		  user.setName(payload.get("name"));
		   user.setPassword(payload.get("password"));
		   user.setRole("guest");
		  
		otpv=otpverify.generateOtp();
		otpverify.sendOtpEmail(payload.get("email"), otpv);
		
		
		return null;
	  }


	  
	}
	


