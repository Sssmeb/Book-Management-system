package com.caorunjia.BMS.view;

import java.awt.BorderLayout;
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
import com.caorunjia.BMS.service.BookAction;

public class UpateAction {
	private JFrame upateFrame;
	private JPanel upatePanel;
	private JButton back;
	private JPanel showPanel;
	private JTextArea bArea;
	Book book=new Book();
	BookAction action =new BookAction();
	
	public UpateAction() throws Exception
	{
		JFrame.setDefaultLookAndFeelDecorated(true); 
		upateFrame = new JFrame("Upate Book");
		upatePanel = new JPanel();
		JLabel lid = new JLabel("input the id which book you wanna update");
		JTextField iid=new JTextField(20);
		JLabel lbookname = new JLabel("input Bookname:"); 
		JTextField ibookname=new JTextField(32);
		JLabel lauthor = new JLabel("input Author:"); 
		JTextField iauthor=new JTextField(35);
		JLabel lstore = new JLabel("input store:"); 
		JTextField istore=new JTextField(35);
		JButton back = new JButton("back");
		
		
		upatePanel.add(lid);
		upatePanel.add(iid);
		upatePanel.add(lbookname);
		upatePanel.add(ibookname);
		upatePanel.add(lauthor);
		upatePanel.add(iauthor);
		upatePanel.add(lstore); 
		upatePanel.add(istore);		
		
		
		
		 iid.addActionListener(new ActionListener()
		 {
			 public void actionPerformed(ActionEvent e)
			 {
				 
				 try {
					if(action.idfind(Integer.valueOf(iid.getText()))!=null)
					 {
						book.setId(Integer.valueOf(iid.getText()));
						try {
							ibookname.setText((action.idfind(Integer.valueOf(iid.getText())).getBookname()));
						} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						} catch (Exception e1) {
						// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							iauthor.setText((action.idfind(Integer.valueOf(iid.getText())).getAuthor()));
						} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
						// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						try {
							istore.setText(String.valueOf(action.idfind(Integer.valueOf(iid.getText())).getStore()));
						} catch (NumberFormatException e1) {
						// TODO Auto-generated catch block
							e1.printStackTrace();
						} catch (Exception e1) {
						// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						ibookname.grabFocus();
					 }
					else
					{
						Error m =new Error();
					}
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			 }
		 });
		 
		 
		 
		 
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
					action.edit(book);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 upateFrame.setVisible(false);
			 }
		 });
			 
		 back.addActionListener(event ->{
			 upateFrame.setVisible(false);
			 });
		 
		 	showPanel = new JPanel();                                       //显示所有书
			bArea =new JTextArea(20,40);
			bArea.setEditable(false);
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
		 
		 upateFrame.pack();
		 
	     upateFrame.add(showPanel,BorderLayout.NORTH);
		 upateFrame.add(upatePanel,BorderLayout.CENTER);
		 upateFrame.add(back,BorderLayout.SOUTH );
		
		 
		 upateFrame.setBounds(600, 300, 500, 600);
		
		
		 upateFrame.setVisible(true);
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		new UpateAction();
		
	}

}
