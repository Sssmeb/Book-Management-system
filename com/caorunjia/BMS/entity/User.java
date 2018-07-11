package com.caorunjia.BMS.entity;

public class User 
{
	private String userName;
	private int id;


	public User(int id,String userName)
	{
		this.id = id;
		this.userName = userName;
	}
	
	public User()
	{
		super();
	}
	
	public int getId()
	{
		return id;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public String getuserName()
	{
		return userName;
	}
	
	public  void setuserName(String userName) 
	{
		this.userName = userName;
	}

	@Override
	public String toString() {
		return "User [  id:"+id+"  userName:" + userName + "]";
	}
}
