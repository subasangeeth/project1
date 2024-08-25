package com.project.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
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
	
	
	@GetMapping("/student")
	public String Login()
	{
		return "student.html";
	}
	
	
	@GetMapping("/home")
	public String studetLogin(@RequestParam String rollno, @RequestParam String password)
	{
		
	boolean b =studentservice.StudentLogin(rollno, password);
	 
	if(b==true)
		return "Home.html";
	 	else
		return "login.html";
	}
	
	
	
	
	@PostMapping("/student")
	public ResponseEntity<Students> addStudent(@RequestParam String rollno, @RequestParam String name, @RequestParam String password) {
	  
		Students students = new Students(rollno, name, password,"Student");
	   
		Students s = studentservice.addStudent(students);
	   
		return ResponseEntity.status(HttpStatus.OK).body(s);
	}
	
	
	
	  @PostMapping("/send-otp")
	    @ResponseBody
	    public String sendOTP(@RequestBody Map<String, String> payload) {
		  
		 
		  user.setEmail(payload.get("email"));
		  user.setName(payload.get("name"));
		  user.setPassword(payload.get("password"));
		  
		System.out.println(payload.get("name"));
		System.out.println(payload.get("email"));
		System.out.println(payload.get("password"));
		
		otpv=otpverify.generateOtp();
		otpverify.sendOtpEmail(payload.get("email"), otpv);
		
		
		return null;
	  }

	      

	   
	    @GetMapping("/verify")
	    public String verifyOTP(@RequestParam("otp") String otp) {
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

	}
	


