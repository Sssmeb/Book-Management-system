package com.caorunjia.BMS.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.caorunjia.BMS.entity.Book;
import com.caorunjia.BMS.service.BookAction;

public class AddAction {
	private JFrame addFrame;
	private JPanel addPanel;
	private JButton back;
	Book book=new Book();
	BookAction action =new BookAction();
	
	public AddAction()
	{
		JFrame.setDefaultLookAndFeelDecorated(true); 
		addFrame = new JFrame("Add Book");
		addPanel = new JPanel();
		JButton back = new JButton("back");
		JLabel lbookname = new JLabel("input Bookname:"); 
		JTextField ibookname=new JTextField(40);
		JLabel lauthor = new JLabel("input Author:"); 
		JTextField iauthor=new JTextField(40);
		JLabel lstore = new JLabel("input store:"); 
		JTextField istore=new JTextField(40);
		
		 addFrame.add(addPanel);
		 addPanel.add(back);
		 addPanel.add(lbookname);
		 addPanel.add(ibookname);
		 addPanel.add(lauthor);
		 addPanel.add(iauthor);
		 addPanel.add(lstore);
		 addPanel.add(istore);
		 
		 ibookname.addActionListener(new ActionListener()
		 {
			 public void actionPerformed(ActionEvent e)
			 {
				 book.setBookName(ibookname.getText());
				 iauthor.grabFocus();
			 }
		 });
		 
		 iauthor.addActionListener(new ActionListener()
		 {
			 public void actionPerformed(ActionEvent e)
			 {
				 book.setAuthor(iauthor.getText());
				 istore.grabFocus();
			 }
		 });
		 
		 istore.addActionListener(new ActionListener()
		 {
			 public void actionPerformed(ActionEvent e)
			 {
				 book.setStore(Integer.valueOf(istore.getText()));
				 try {
					action.add(book);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 addFrame.setVisible(false);
			 }
		 });
			 
		 back.addActionListener(event ->{
			 addFrame.setVisible(false);
			 });
		 
		 addFrame.add(addPanel,BorderLayout.CENTER);
		 addFrame.add(back,BorderLayout.SOUTH );
		
		 addFrame.setBounds(600, 300, 500, 500);
		 addPanel.setBounds(200, 200, 200, 200);
		
		 addFrame.setVisible(true);
		
	}
	public static void main(String[] args) {
		//new AddAction();
		
	}

}
