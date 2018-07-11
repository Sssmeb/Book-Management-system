package com.caorunjia.BMS.view;

import java.awt.*;

import com.caorunjia.BMS.entity.User;
import com.caorunjia.BMS.service.BookAction;
import com.caorunjia.BMS.service.UserAction;
import com.caorunjia.BMS.util.DbUtil;
import com.caorunjia.BMS.view.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

import javax.swing.*;

public class View extends JFrame 
{
	private JFrame enterFrame;
	private JPanel buttonPanel;
	private JTextField jt;
	private ResultSet rs;

	public View()throws Exception
	 {
		 JFrame.setDefaultLookAndFeelDecorated(true); 
		 enterFrame = new JFrame("Book Management System");
		 buttonPanel = new JPanel();
		 JButton enter = new JButton("enter");
		 JTextField jt=new JTextField(12);
		 ImageIcon imageIcon = new ImageIcon("./src/images/111.jpg");
		 JLabel label1 = new JLabel("student number:"); 
		 JLabel label2 = new JLabel( imageIcon, SwingConstants.RIGHT);
		 
		 enterFrame.setLayout(new FlowLayout(FlowLayout.CENTER));
		 enterFrame.pack();
		 imageIcon.setImage(imageIcon.getImage().getScaledInstance(300,300,Image.SCALE_DEFAULT));
		 enterFrame.setBounds(600, 300, 550, 550);
		 buttonPanel.setBounds(200, 200, 200, 200);
		 
		 enterFrame.add(buttonPanel);
		 buttonPanel.add(label2);
		 buttonPanel.add(label1);
		 buttonPanel.add(jt);
		 buttonPanel.add(enter);
		
		 
		 enter.addActionListener(event ->{
			 String content=jt.getText();             //’˝‘Ú≈–∂œ—ß∫≈
			 String pattern ="^(3)(1|2)(1)(\\d)(0)(\\d)(\\d)(\\d)(\\d)(\\d)$";
			 boolean isMatch = Pattern.matches(pattern, content);
			 if(isMatch==true) 
			 {
				 try {
					Judgeuser a=new Judgeuser(content);
				} catch (Exception e) {
					e.printStackTrace();
				}
				 enterFrame.setVisible(false);
				 MainView m=new MainView(jt.getText());
				}
				
			 
			 else
			 {
				 Error m =new Error();
			 }
			 
			});
		 
		 
		 enterFrame.pack();
		
		 
		 enterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 enterFrame.setVisible(true);
		 
		 
	 }
	
public static void main(String args[]) throws Exception
	 {
		
		 new View();
	 }
}
	 




	 
