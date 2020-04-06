package com.niit.controller;
//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.model.Book;
import com.niit.service.BookService;

@Controller
@RequestMapping("/book")
public class BookController 
{
	@Autowired
	BookService bookService;
	
	@RequestMapping("/add")
	public String addBook(ModelMap map)
	{
		map.addAttribute("book",new Book());
		return "addbook";
	}
	
	@RequestMapping(value= {"/add"},method=RequestMethod.POST)
	public String addBook(@ModelAttribute("book") Book b)
	{
		bookService.addBook(b);
		return "redirect:/book/display";
	}

	@RequestMapping(value= {"/update"},method=RequestMethod.POST)
	public String updateBook(@ModelAttribute("b") Book b)
	{
		bookService.updateBook(b);
		return "redirect:/book/display";
	}
	
	@RequestMapping("/display")
	public String displayBooks(ModelMap map)
	{
		map.addAttribute("books",bookService.displayBooks());
		return "displaybooks";
	}
	
	@RequestMapping("/display/{bookid}")
	public String displayBooks(@PathVariable("bookid") int bookid,ModelMap map)
	{
		Book b=bookService.displayByBookId(bookid);
		map.addAttribute("book",b);
		return "displaybook";
	}
	
	@RequestMapping("/delete/{bookid}")
	public String deleteBook(@PathVariable("bookid") int bookid)
	{
		bookService.deleteBook(bookid);
		return "redirect:/book/display";
	}
	
	@RequestMapping("/edit/{bookid}")
	public String editBook(@PathVariable("bookid") int bookid,ModelMap map)
	{
		Book b=bookService.displayByBookId(bookid);
		map.addAttribute("b",b);
		return "addbook";
	}
}
