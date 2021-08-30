package vn.ptit.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.ptit.entities.Book;
import vn.ptit.repositories.BookRepository;

@Service
public class BookService {
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	BookRepository bookRepository;
	
	public List<Book> searchBookById(int id) {
		String jpql = "select b from Book b where b.id = " + id;
		Query query = entityManager.createQuery(jpql, Book.class);
		return query.getResultList();
	}
	
}
