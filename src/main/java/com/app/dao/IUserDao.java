package com.app.dao;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Pdffile;

public interface IUserDao {

 List<Pdffile> getallbooks();

String deletebook(Integer id);
 
Pdffile addBook(MultipartFile pdf, String authName ,String bookName ) throws IOException;

}
