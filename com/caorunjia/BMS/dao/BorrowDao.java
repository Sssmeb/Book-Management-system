package com.caorunjia.BMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.caorunjia.BMS.entity.Borrow;
import com.caorunjia.BMS.util.DbUtil;

public class BorrowDao {
	public List<Borrow> query(Integer userid) throws Exception
	{             //查询输出所有借书记录
		List<Borrow> result =new ArrayList<Borrow>();
		
		Connection conn= DbUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select id,userid,bookid,borrow_time from t_borrow"+" where userid=?");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		ptmt.setInt(1,userid);
		ResultSet rs = ptmt.executeQuery();
		
		Borrow g=null;
		while (rs.next())
		{
			g=new Borrow();
			g.setId(rs.getInt("id"));
			g.setUserid(rs.getInt("userid"));
			g.setBookid(rs.getInt("bookid"));
			g.setBorrow_time(rs.getDate("borrow_time"));
			result.add(g);
		}
		return result;
	}
	
	
	public void borBook(Integer userid,Integer bookid) throws Exception 
	{                    // 借书
		 Connection conn= DbUtil.getConnection();
		 String sql =""+" insert into t_borrow "+
		 "(userid,bookid,borrow_time)"+
				 " values("+"?,?,current_date())";
		 String sql2=""+" update t_book "+" set store=(store-1)"+
				 " where id=? ";
		 PreparedStatement ptmt=conn.prepareStatement(sql);     //预编译
		 PreparedStatement ptmt1=conn.prepareStatement(sql2);    
		 
		 		 
		 ptmt.setInt(1, userid);
		 ptmt.setInt(2, bookid);
		 ptmt1.setInt(1, bookid);
		 ptmt.executeUpdate();
		 ptmt1.executeUpdate();
	}
	
	public void delBorrow(Integer userid,Integer bookid) throws SQLException
	{                //还书
		Connection conn= DbUtil.getConnection();
		 String sql =""+" delete from t_borrow "+
		 " where userid=?"+" and bookid=? ";
		 String sql2=""+" update t_book "+" set store=(store+1)"+
				 " where id=? ";

		 PreparedStatement ptmt=conn.prepareStatement(sql);
		 PreparedStatement ptmt1=conn.prepareStatement(sql2);
		 ptmt.setInt(1, userid);
		 ptmt.setInt(2, bookid);
		 ptmt1.setInt(1, bookid);
		 ptmt.executeUpdate();
		 ptmt1.executeUpdate();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
