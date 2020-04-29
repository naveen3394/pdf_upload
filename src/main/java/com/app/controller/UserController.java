package com.app.controller;

import java.io.Console;
import java.io.IOException;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.dao.IUserDao;
import com.app.pojos.Pdffile;

@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
@Autowired
IUserDao udao;

@GetMapping("/list")
public ResponseEntity<List<Pdffile>> listOfUsers()
{
	List<Pdffile> listAllBooks=udao.getallbooks();
	System.out.println(listAllBooks);
	if(listAllBooks.size()!=0)
		return new ResponseEntity<List<Pdffile>>(listAllBooks, HttpStatus.OK);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
}

@GetMapping("/delete/{id}")
public ResponseEntity<Void> deletebook(@PathVariable Integer id)
{
	//Integer id1=Integer.getInteger(id);
	System.out.println(id);
	//List<Pdffile> listAllBooks=udao.getallbooks();
	String str =udao.deletebook(id);
	
		return new ResponseEntity<Void>(HttpStatus.OK);
}

@PostMapping(consumes = { "multipart/form-data" })
public ResponseEntity<?> addnewpdf(@RequestParam MultipartFile pdf, @RequestParam String authName,@RequestParam String bookName) throws IOException {
		
		try {
			System.out.println(pdf);
			System.out.println(authName);
		if (pdf != null) {
			Pdffile  p=udao.addBook(pdf,authName,bookName);
			return new ResponseEntity<Pdffile>(p, HttpStatus.CREATED);
		}
	} catch (RuntimeException e) {
		e.printStackTrace();
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	return null;
}
@GetMapping("/test")
public ResponseEntity<String> test()
{
	
	//Integer id1=Integer.getInteger(id);
	//List<Pdffile> listAllBooks=udao.getallbooks();
	String str =new String("server is up and running");
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	Date date = new Date();
	LocalDateTime today = LocalDateTime.now();
		return new ResponseEntity<String>("server is up and running     "+today,HttpStatus.OK);
}


}
