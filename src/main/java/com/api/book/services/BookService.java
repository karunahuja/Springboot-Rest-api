package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

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
		try {
		book=list.stream().filter(e->e.getId()==id).findFirst().get();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}


	public static void setList(List<Book> list) {
		BookService.list = list;
	}
	
	
	
	public Book addBook(Book b) {
		list.add(b);
		return b;
		
	}
	
	public void deleteBook(int bid) {
		// TODO Auto-generated method stub

         Book book=null;
		
		book=list.stream().filter(e->e.getId()==bid).findFirst().get();
		
		 list.remove(book);
		 
		 
}

	
	public void updateBook(Book book,int bookId)
	{
		
		list=list.stream().map(b->{
			
			if(b.getId()==bookId) {
				b.setTitle(book.getTitle());
				b.setAuthor(book.getAuthor());
				
			}
			
			return b;
		}).collect(Collectors.toList());
	}
	
	
	
	
	

}
