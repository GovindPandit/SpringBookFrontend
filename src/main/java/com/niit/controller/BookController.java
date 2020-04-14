package com.niit.controller;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

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
	public String addBook(@ModelAttribute("book") Book b,@RequestParam("image") MultipartFile bookImage,ModelMap map)
	{
		bookService.addBook(b);
		
		String path="C:\\Users\\Niit1\\git\\SpringBookFrontend\\src\\main\\webapp\\WEB-INF\\images\\";
		Path p=Paths.get(path+b.getBookname());
		if (!Files.exists(p))
		{    
			try
			{
				Files.createDirectory(p);
				System.out.println("Directory created");
			}
			catch (Exception e) 
			{
				System.out.println(e);
			}
        }
		
		List<String> files=displayImage(b.getBookname());
		
		path=String.valueOf(p.toString()+"\\"+(files.size()+1)+".jpg");
		System.out.println(path);
		File imageFile=new File(path);
		
		if(!bookImage.isEmpty())
		{
			try
			{
				byte buffer[]=bookImage.getBytes();
				FileOutputStream fos=new FileOutputStream(imageFile);
				BufferedOutputStream bos=new BufferedOutputStream(fos);
				bos.write(buffer);
				bos.close();
			}
			catch (Exception e) 
			{
				System.out.println(e);
			}
		}
		
		map.addAttribute("msg","Book addded sucessfully");
		map.addAttribute("type","success");
		map.addAttribute("pagename","/book/display");
		return "popup";
	}

	public List<String> displayImage(String bookName)
	{

		List<String> images=new ArrayList();
		
		try
		{
			String path="C:\\Users\\Niit1\\git\\SpringBookFrontend\\src\\main\\webapp\\WEB-INF\\images\\";
			Path p=Paths.get(path+bookName);
			DirectoryStream<Path> files=Files.newDirectoryStream(p,"*.*");
			
			for(Path file:files)
			{
//				FileInputStream fis=new FileInputStream(file.toString());
//				byte[] arr=new byte[fis.available()];
//				fis.read(arr);
				
				images.add(file.getFileName().toString());
			}
			
		}
		catch (Exception e) 
		{
			System.out.println(e);
		}
		return images;
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
		List<Book> books=new ArrayList<Book>();
		for(Book b:bookService.displayBooks())//Harry Potter, Harry Potter 2
		{
			List<String> im=displayImage(b.getBookname());
			if(!im.isEmpty())
			b.setBookimage(im.get(0));	
			books.add(b);
		}
		map.addAttribute("books",books);
		return "displaybooks";
	}
	
	@RequestMapping("/display/{bookid}")
	public String displayBooks(@PathVariable("bookid") int bookid,ModelMap map)
	{
		Book b=bookService.displayByBookId(bookid);
		List<String> images=displayImage(b.getBookname());
		b.setBookimage(images.get(0));
		map.addAttribute("book",b);
		return "displaybook";
	}
	
	@RequestMapping("/delete/{bookid}")
	public String deleteBook(@PathVariable("bookid") int bookid,ModelMap map)
	{
		bookService.deleteBook(bookid);
		map.addAttribute("msg","Book deleted sucessfully");
		map.addAttribute("type","success");
		map.addAttribute("pagename","/book/display");
		return "popup";
	}
	
	@RequestMapping("/edit/{bookid}")
	public String editBook(@PathVariable("bookid") int bookid,ModelMap map)
	{
		Book b=bookService.displayByBookId(bookid);
		map.addAttribute("b",b);
		return "addbook";
	}
	
	@RequestMapping("/hightolow")
	public String highttolow(ModelMap map)
	{
		List<Book> books=new ArrayList<Book>();
		for(Book b:bookService.displayBooksHighToLow())
		{
			List<String> im=displayImage(b.getBookname());
			if(!im.isEmpty())
			b.setBookimage(im.get(0));	
			books.add(b);
		}
		map.addAttribute("books",books);
		return "displaybooks";
	}
	
	@RequestMapping("/lowtohigh")
	public String lowtohigh(ModelMap map)
	{
		List<Book> books=new ArrayList<Book>();
		for(Book b:bookService.displayBooksLowToHigh())
		{
			List<String> im=displayImage(b.getBookname());
			if(!im.isEmpty())
			b.setBookimage(im.get(0));	
			books.add(b);
		}
		map.addAttribute("books",books);
		return "displaybooks";
	}
	
	@RequestMapping("/search")
	public String search(@RequestParam("search") String search,ModelMap map)
	{
		List<Book> books=new ArrayList<Book>();
		for(Book b:bookService.search(search))
		{
			List<String> im=displayImage(b.getBookname());
			if(!im.isEmpty())
			b.setBookimage(im.get(0));	
			books.add(b);
		}
		map.addAttribute("books",books);
		return "displaybooks";
	}
	
	
}
