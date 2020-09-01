package com.example.bookservice;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.env.Environment;

@RestController
public class BookServiceController {
	
	@Autowired
	private BookRepository evRepository;
	
	@Autowired
	private Environment env;
	
	
	@GetMapping("/books")
	public List<Book> retrieveBooksList() {
		
		List<Book> ev = evRepository.findAll();
		System.out.println(env.getProperty("local.server.port"));
		
	  return ev;
	}
	
	@GetMapping(value="/books/{bookId}/{available_copies}")
	public void updateBookList(@PathVariable("bookId")String bookId,@PathVariable("available_copies")String available_copies) {
		System.out.println(env.getProperty("local.server.port"));
		 evRepository.updateBookList(bookId,Integer.parseInt(available_copies));
	}
}

