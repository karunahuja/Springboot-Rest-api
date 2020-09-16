package com.api.book.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.api.book.entities.Book;


@Component
public class BookService {
	
	private static List<Book> list=new ArrayList<>();
	
	static {
		
		
		list.add(new Book(12,"Java Complete","XYZ"));
		
		list.add(new Book(13,"python","ABC"));
		
		
		list.add(new Book(14,"Java not  Complete","XYsZ"));
		
		list.add(new Book(15,"pythons","AaBC"));
		
		
		
	}

	public static List<Book> getAllBooks() {
		return list;
	}
	
	
	public static Book getBookById(int id) {
		Book book=null;
		
		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		
		return book;
	}


	public static void setList(List<Book> list) {
		BookService.list = list;
	}
	
	
	
	public void addBook(Book b) {
		list.add(b);
		
	}
	
	
	

}
