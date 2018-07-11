package com.caorunjia.BMS.entity;

import java.util.Date;

public class Book 
{
	private String bookname;
	private String author;
	private int id;
	private Date update_time;
	private int store;
	
	public Book(int id,String bookname,String author,Date update_time,int store)
	{
		this.id = id;
		this.bookname = bookname;
		this.author = author;
		this.update_time=update_time;
		this.store=store;
		
	}
	
	public Book()
	{
		super();
	}
	

	public String getBookname()
	{
		return bookname;
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getStore()
	{
		return store;
	}
	
	public Date getUpdate_time()
	{
		return update_time;
	}
	
	public  void setBookName(String bookname) 
	{
		this.bookname = bookname;
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	public void setStore(int store)
	{
		this.store=store;
	}
	
	public void setUpdate_time(Date update_time)
	{
		this.update_time=update_time;
	}

	@Override
	public String toString() {
		return "Book [bookname=" + bookname + ", author=" + author + ", id=" + id + ", update_time=" + update_time
				+ ", store=" + store + "]";
	}
	
	
	

}
