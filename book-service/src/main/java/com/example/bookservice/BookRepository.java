package com.example.bookservice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Repository
public interface BookRepository extends CrudRepository<Book,Long>{
    
	List<Book> findAll();
	
    @Transactional
	@Modifying(clearAutomatically = true)
	@Query(value="update Book b set b.available_copies=:available_copies WHERE b.book_id =:bookId",nativeQuery=true)
	void updateBookList(@Param("bookId")String bookId,@Param("available_copies") Integer available_copies);
	

}


