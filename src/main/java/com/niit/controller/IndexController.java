package com.niit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController
{
	@RequestMapping(value= {"","/","/home"})
	public String m1()
	{
		return "index";
	}
	
	@RequestMapping(value= {"/aboutus"})
	public String m2()
	{
		return "aboutus";
	}
	
	@RequestMapping(value= {"/contactus"})
	public String m3()
	{
		return "contactus";
	}
}
