package com.caorunjia.BMS.service;

import java.util.List;

import com.caorunjia.BMS.dao.UserDao;
import com.caorunjia.BMS.entity.User;

public class UserAction {

	public void add(User user) throws Exception    //增
	{
		UserDao dao=new UserDao();
		dao.addUser(user);
	}
	
	public List<User> query() throws Exception     //输出全部
	{
		UserDao dao=new UserDao();
		return dao.query();
	}
	
	public User find(String userName) throws Exception   //查单本书
	{
		UserDao dao=new UserDao();
		return dao.get(userName);
	}
	public static void main(String[] args) 
	{
	}
}
