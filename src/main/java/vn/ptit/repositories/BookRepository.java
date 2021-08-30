package vn.ptit.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.ptit.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{

}
