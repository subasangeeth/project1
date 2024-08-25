package com.project.utils;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class OTPverify {
	 
	public String OTP;
  
	    @Autowired
	    private JavaMailSender mailSender;

	    private static final int OTP_LENGTH = 6;

	    public String generateOtp() {
	        SecureRandom random = new SecureRandom();
	        StringBuilder otp = new StringBuilder();
	        for (int i = 0; i < OTP_LENGTH; i++) {
	            otp.append(random.nextInt(10));
	        }
	        
	        OTP=otp.toString();
	        return otp.toString();
	    }

	    public void sendOtpEmail(String toEmail, String otp) {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setTo(toEmail);
	        message.setSubject("OTP VERFICATION");
	        message.setText("OTP : " + otp);
	        mailSender.send(message);
	    }
	}

