package com.caorunjia.BMS.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Error 
{
	private JFrame errorFrame;
	private JButton ok;
	
	public Error()
	{
		JFrame.setDefaultLookAndFeelDecorated(true); 
		errorFrame = new JFrame("Error!!!");
		JLabel lerror = new JLabel("  Format error!Please re-input!");
		JButton ok = new JButton("ok");
		
		Font dialog = new Font("Dialog",Font.BOLD,25);
		lerror.setFont(dialog);
		errorFrame.setBackground(Color.red);
		errorFrame.add(lerror,BorderLayout.CENTER);
		errorFrame.add(ok,BorderLayout.SOUTH );
		
		ok.addActionListener(event ->{
			 errorFrame.setVisible(false);
			 });
		
		errorFrame.setBounds(750, 300, 380, 350);
		
		errorFrame.setVisible(true);
	}
	
	
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//new Error();
	}
}

