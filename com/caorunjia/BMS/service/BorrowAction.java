package com.caorunjia.BMS.service;

import java.util.List;

import com.caorunjia.BMS.dao.BorrowDao;
import com.caorunjia.BMS.entity.Borrow;


public class BorrowAction {

	public List<Borrow> query(Integer userid) throws Exception     //���ȫ��
	{
		BorrowDao dao=new BorrowDao();
		return dao.query(userid);
	}
	
	public void del(Integer userid,Integer bookid) throws Exception   //ɾ
	{
		BorrowDao dao=new BorrowDao();
		dao.delBorrow(userid,bookid);
	}
	
	public void bor(Integer userid,Integer bookid) throws Exception   //��
	{
		BorrowDao dao=new BorrowDao();
		dao.borBook(userid,bookid);
	}
}
