package com.app.dao;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.app.pojos.Pdffile;

@Repository
@Service
@Transactional
public class UserDaoImpl implements IUserDao {

	@PersistenceContext
	private EntityManager mgr;

	@Override
	public List<Pdffile> getallbooks() {
		String jpql = "select p from Pdffile p";
		return mgr.unwrap(Session.class).createQuery(jpql, Pdffile.class).getResultList();
	}
	@Override
	public Pdffile addBook(MultipartFile pdf, String authName, String bookName) throws IOException {
		System.out.println("Book Name "+bookName+"Author name  " +authName);
		Pdffile p1 = new Pdffile(pdf.getBytes(),authName,bookName);
		mgr.unwrap(Session.class).persist(p1);
		return p1;
	}
	@Override
	public String deletebook(Integer id) {
		System.out.println(id);
		String str =new String("Book Deleted Sucessfully");
		
		String jpql="select p from Pdffile p where p.pdfId=:pdfid";

      Pdffile book_to_be_removed= mgr.unwrap(Session.class).createQuery(jpql, Pdffile.class).setParameter("pdfid",id)
				.getSingleResult();
      System.out.println(book_to_be_removed);
      mgr.unwrap(Session.class).remove(book_to_be_removed);
		return str;
	}

}
