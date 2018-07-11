package com.caorunjia.BMS.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.caorunjia.BMS.entity.Book;
import com.caorunjia.BMS.util.DbUtil;


public class BookDao {

	public void addBook(Book g) throws Exception 
	{                    // 增加书
		 Connection conn= DbUtil.getConnection();
		 String sql =""+"insert into t_book"+"(bookName,author,update_time,store)"+"values("+"?,?,current_date(),?)";
		 PreparedStatement ptmt=conn.prepareStatement(sql);     //预编译
		 
		 ptmt.setString(1, g.getBookname());
		 ptmt.setString(2,g.getAuthor());
		 ptmt.setInt(3, g.getStore());
		 ptmt.execute();
	}
	
	
	public void updateBook(Book g) throws SQLException
	{                  //更新书
		 Connection conn= DbUtil.getConnection();
		 String sql =""+" update t_book "+
		 " set bookName=?,author=?,update_time=current_date(),store=? "+
		 "where id=?";
		 PreparedStatement ptmt=conn.prepareStatement(sql);
		 
		 ptmt.setString(1, g.getBookname());
		 ptmt.setString(2,g.getAuthor());
		 ptmt.setInt(3, g.getStore());
		 ptmt.setInt(4, g.getId());
		 ptmt.executeUpdate();
	}
	
	
	public void delBook(Integer id) throws SQLException
	{                //删除书
		Connection conn= DbUtil.getConnection();
		 String sql =""+" delete from t_book "+
		 " where id=? ";
		 PreparedStatement ptmt=conn.prepareStatement(sql);
		 
		 ptmt.setInt(1, id);
		 ptmt.execute();
	}
	
	
	public Book get(String bookName) throws SQLException	
	{                    //通过书名查询单本书
		
		Connection conn= DbUtil.getConnection();
		 String sql =""+
		" select * from  t_book "+
		" where bookName like ? ";
		 
		PreparedStatement ptmt=conn.prepareStatement(sql);
		
		ptmt.setString(1, "%"+bookName+"%");
		
		ResultSet rs = ptmt.executeQuery();		
		Book g=null;
		while(rs.next()) {
			g=new Book();
			g.setId(rs.getInt("id"));
			g.setBookName(rs.getString("bookName"));
			g.setAuthor(rs.getString("author"));
			g.setUpdate_time(rs.getDate("update_time"));
			g.setStore(rs.getInt("store"));
			 ;
		}
		return g;
	}
	
	public Book idget(Integer id) throws SQLException	
	{                    //通过id查询书
		Book g=null;
		Connection conn= DbUtil.getConnection();
		 String sql =""+
		" select * from  t_book "+
		" where id = ? ";
		PreparedStatement ptmt=conn.prepareStatement(sql);
		 
		ptmt.setInt(1, id);
		ResultSet rs=ptmt.executeQuery();
		while(rs.next()) {
			g=new Book();
			g.setId(rs.getInt("id"));
			g.setBookName(rs.getString("bookName"));
			g.setAuthor(rs.getString("author"));
			g.setUpdate_time(rs.getDate("update_time"));
			g.setStore(rs.getInt("store"));
			 ;
		}
		return g;
	}
	
	
	public List<Book> query() throws Exception
	{             //查询输出所有
		List<Book> result =new ArrayList<Book>();
		
		Connection conn= DbUtil.getConnection();
		StringBuilder sb=new StringBuilder();
		sb.append("select id,bookName,author,update_time,store from t_book");
		
		PreparedStatement ptmt=conn.prepareStatement(sb.toString());
		
		ResultSet rs = ptmt.executeQuery();
		
		Book g=null;
		while (rs.next())
		{
			g=new Book();
			g.setId(rs.getInt("id"));
			g.setBookName(rs.getString("bookName"));
			g.setAuthor(rs.getString("author"));
			g.setStore(rs.getInt("store"));
			g.setUpdate_time(rs.getDate("update_time"));
			result.add(g);
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
