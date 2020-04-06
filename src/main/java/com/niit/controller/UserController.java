package com.niit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.model.User;
import com.niit.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController 
{
	@Autowired
	UserService userService;
	
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
}
