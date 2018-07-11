package com.caorunjia.BMS.service;

import java.util.List;
import com.caorunjia.BMS.dao.BookDao;
import com.caorunjia.BMS.entity.Book;

public class BookAction {

		public void add(Book book) throws Exception    //增
		{
			BookDao dao=new BookDao();
			dao.addBook(book);
		}
		
		public void edit(Book book) throws Exception   //改
		{
			BookDao dao=new BookDao();
			dao.updateBook(book);
		}
		
		public void del(Integer id) throws Exception   //删
		{
			BookDao dao=new BookDao();
			dao.delBook(id);
		}
		
		public List<Book> query() throws Exception     //输出全部
		{
			BookDao dao=new BookDao();
			return dao.query();
		}
		
		public Book find(String bookName) throws Exception   //查单本书
		{
			BookDao dao=new BookDao();
			return dao.get(bookName);
		}
		
		public Book idfind(Integer id) throws Exception   //查单本书
		{
			BookDao dao=new BookDao();
			return dao.idget(id);
		}
		
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
