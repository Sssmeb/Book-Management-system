package com.caorunjia.BMS.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.caorunjia.BMS.entity.User;
import com.caorunjia.BMS.service.UserAction;
import com.caorunjia.BMS.util.DbUtil;

public class Judgeuser  
{
	//判断是否已经存在用户
	public Judgeuser(String userName) throws Exception 
	{
	 Connection conn= DbUtil.getConnection();
	 String sql=""+ "select * from t_user "+" where userName=? ";
	 PreparedStatement ptmt=conn.prepareStatement(sql);
	 
	 ptmt.setString(1,userName);
	 ResultSet rs=ptmt.executeQuery();
	 if(rs.next())
	 {
	}
	 else
	 {
		 User user =new User();                   //添加用户
		 user.setuserName(userName);
		 UserAction action =new UserAction();
		 try {
			action.add(user);
		} catch (Exception e) {
			e.printStackTrace();
		}
	 }
	
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	}
}

