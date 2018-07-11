package com.caorunjia.BMS.entity;

import java.util.Date;

public class Borrow {
	private int userid ;
	private int bookid;
	private int id;
	private Date borrow_time;
	
	public Borrow(int id,int userid,int bookid,Date borrow_time)
	{
		this.id = id;
		this.userid = userid;
		this.bookid = bookid;
		this.borrow_time=borrow_time;
		
	}
	public Borrow()
	{
		super();
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getBookid() {
		return bookid;
	}
	public void setBookid(int bookid) {
		this.bookid = bookid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getBorrow_time() {
		return borrow_time;
	}
	public void setBorrow_time(Date borrow_time) {
		this.borrow_time = borrow_time;
	}
	@Override
	public String toString() {
		return "Borrow [id : "+id+" userid:" + userid + "  bookid:" + bookid + "  borrow_time:" + borrow_time + "]";
	}
	
	
}
