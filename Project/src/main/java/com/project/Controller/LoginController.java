package com.project.Controller;

import java.util.HashMap;
import java.util.Map;

import com.project.Repo.StudentRepo;
import com.project.Repo.otherUserRepo;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.project.Model.Students;
import com.project.Model.otherUsers;
import com.project.Service.otherUsersService;
import com.project.Service.studentService;
import com.project.utils.OTPverify;

@Controller
@SessionAttributes("username")
public class LoginController {
	@Autowired
	StudentRepo studentRepo;
	@Autowired
	studentService studentservice;
@Autowired
otherUserRepo otherUserRepo;




	@Autowired
	otherUsersService otheruserservice;


	@Autowired
	OTPverify otpverify;
	String otpv;


	 otherUsers user=new otherUsers();
	@GetMapping("/")
	public String Login()
	{
		return "login.html";
	}
	
	
	@GetMapping("/loginAgain")
	public String LoginAgain()
	{
		return "login.html";
	}

@GetMapping("/home")
public String Home() {
	return "home.html";
}

	@GetMapping("/student")
	public String studentLogn(@RequestParam String rollno, @RequestParam String password, Model model,HttpSession session)
	{
		boolean o =studentservice.StudentLogin(rollno,password);

		if(o==true) {
			String username=studentRepo.findByrollno(rollno).getName();
			session.setAttribute("username",username);
			return "redirect:/home";
		}

		else
			return "redirect:/loginAgain";
	}
	

	@GetMapping("/newstudent")
	public String addStudent(@RequestParam String rollno, @RequestParam String name, @RequestParam String password) {
	  
		Students students = new Students(rollno, name, password,"Student");
	   
		studentservice.addStudent(students);
	   
		return "Home.html";
	}
	
	
	@GetMapping("/user")
	public String guestLogin(@RequestParam String email,@RequestParam("pass") String password,Model model,HttpSession session)
	{
		boolean o =otheruserservice.userLogin(email,password);

	if(o==true) {
		String username= otherUserRepo.findByemail(email).getName();
		session.setAttribute("username",username);
		System.out.println(username);
		return "redirect:/home";
	}
	 	else
		return "redirect:/loginAgain";
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



	@RestController
	public class UserController {

		@GetMapping("/api/username")
		public Map<String, String> getUsername(HttpSession session) {
			Map<String, String> response = new HashMap<>();
			String username = (String) session.getAttribute("username"); // Get the username from session

			if (username != null) {
				response.put("username", username);
			} else {
				response.put("error", "Username not found in session");
			}

			return response;
		}
	}

	}
	


