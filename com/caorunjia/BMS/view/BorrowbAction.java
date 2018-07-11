package com.caorunjia.BMS.view;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import com.caorunjia.BMS.entity.Book;
import com.caorunjia.BMS.entity.User;
import com.caorunjia.BMS.service.BookAction;
import com.caorunjia.BMS.service.BorrowAction;
import com.caorunjia.BMS.service.UserAction;

public class BorrowbAction {
	private JFrame borFrame;
	private JPanel borPanel;
	private JButton back;
	private JPanel showPanel;
	private JTextArea bArea;
	private int bookid=0;
	private int userid=0;
	public String userName1=null;
	private int store;
	Book book=new Book();
	User user = new User();
	BookAction action =new BookAction();
	BorrowAction baction =new BorrowAction();
	UserAction uaction = new UserAction();
	
	
	public BorrowbAction(String userName) throws Exception
	{
		userName1=userName;
		JFrame.setDefaultLookAndFeelDecorated(true); 
		borFrame = new JFrame("Borrow Book");
		borPanel = new JPanel();
		JButton back = new JButton("back");
		JLabel lid = new JLabel("input bookid:"); 
		JTextField iid=new JTextField(20);
		
		borFrame.add(borPanel);
		borPanel.add(back);
		borPanel.add(lid);
		borPanel.add(iid);
		
		showPanel = new JPanel();                                       //显示所有书
		bArea =new JTextArea(20,40);
		JScrollPane scrollPane =new JScrollPane(bArea);
		scrollPane.setHorizontalScrollBarPolicy( 
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollPane.setVerticalScrollBarPolicy( 
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		showPanel.add(scrollPane);
		List<Book> list = null;
		list=action.query();
		bArea.append("All books:"+"\n"+"\n");
		for(Book g:list)
		{
		bArea.append("id:"+String.valueOf(g.getId())+
				"  bookname:"+String.valueOf(g.getBookname())+
				"  author:"+String.valueOf(g.getAuthor())+
				"  updatetime:"+String.valueOf(g.getUpdate_time())+
				"  store:"+String.valueOf(g.getStore())+
				"\n"+
				"-----------------------------------------------------------------------------------------------------------"+
				"\n");
		}
		
		bArea.setLineWrap(true);
		
		
		userid=(uaction.find(userName1)).getId();
		
		iid.addActionListener(new ActionListener()
		 {
			 public void actionPerformed(ActionEvent e)
			 {
				 bookid =Integer.valueOf(iid.getText());
				 try {
						baction.bor(userid,bookid);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 borFrame.setVisible(false);
				
			 }
		 });
		
		back.addActionListener(event ->{
			 borFrame.setVisible(false);
			 });
		 
		 borFrame.add(borPanel);
		 borFrame.add(back );
		 borFrame.add(showPanel);
		 borFrame.setLayout(new FlowLayout());
		
		 borFrame.setBounds(600, 300, 700, 500);
		 borPanel.setBounds(200, 200, 200, 200);
		 
		 borFrame.setVisible(true);
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//new BorrowbAction();
	}
}
