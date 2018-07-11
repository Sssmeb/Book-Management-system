package com.caorunjia.BMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.caorunjia.BMS.entity.User;
import com.caorunjia.BMS.util.DbUtil;

public class UserDao {

	public void addUser(User h) throws Exception 
	{                    // 增加用户
		 Connection conn= DbUtil.getConnection();
		 String sql =""+" insert into t_user "+" set userName=? ";
		 PreparedStatement ptmt=conn.prepareStatement(sql);
		 
		 ptmt.setString(1, h.getuserName());
		 ptmt.executeUpdate();
	}
	
	public List<User> query() throws Exception
	{             //查询输出所有用户
		List<User> result =new ArrayList<User>();
		
		Connection conn= DbUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select id,userName from t_user");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		ResultSet rs = ptmt.executeQuery();
		
		User g=null;
		while (rs.next())
		{
			g=new User();
			g.setId(rs.getInt("id"));
			g.setuserName(rs.getString("userName"));
			result.add(g);
		}
		return result;
	}
	
	public User get(String userName) throws SQLException	
	{                    //查询单个用户
		User g=null;
		Connection conn= DbUtil.getConnection();
		 String sql =""+
		" select * from  t_user "+
		" where userName = ? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		 
		ptmt.setString(1, userName);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()) {
			g=new User();
			g.setId(rs.getInt("id"));
			g.setuserName(rs.getString("userName"));
		}
		return g;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

