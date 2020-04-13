package com.niit.controller;

import java.lang.reflect.Method;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.niit.model.User;
import com.niit.others.Email;
import com.niit.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	UserService userService;
	
	User user;
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
	
	@RequestMapping("/add")
	public String register(ModelMap map)
	{
		map.addAttribute("user",new User());
		return "register";
	}
	
	@RequestMapping(value= {"/add"},method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user") User user)
	{
		userService.addUser(user);
		return "redirect:/user/login";
	}
	
	@RequestMapping(value= {"/enterusername"})
	public String m1()
	{
		return "enterusername";
	}
	
	
	@RequestMapping(value= {"/forgot"})
	public String forgot(@RequestParam("username") String username,ModelMap map)
	{
		user=userService.displayUserByUsername(username);
		Random r=new Random();
		int random=r.nextInt(8999)+1000;
		
		Email email=new Email(user.getEmail(), "Password Reset", "OTP: "+random);
		email.sendEmail();
		
		map.addAttribute("otp",random);
		return "confirmotp";
	}
	
	@RequestMapping("/checkotp")
	public String checkotp(@RequestParam("userotp") int userotp,@RequestParam("otp") int otp)
	{
		if(userotp==otp)
		{
			return "changepassword";
		}
		else
		{
			return "redirect:/user/login";
		}
	}
	
	
	@RequestMapping("/updatepassword")
	public String updatepassword(@RequestParam("password") String password,@RequestParam("cpassword") String cpassword)
	{
		if(password.equals(cpassword))
		{
			password=new BCryptPasswordEncoder().encode(password);
			user.setPassword(password);
			userService.updateUser(user);
		}
		
		return "redirect:/user/login";
	}
}
