package com.caorunjia.BMS.view;

import java.awt.BorderLayout;
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
import com.caorunjia.BMS.service.UserAction;

public class MainView extends JFrame
{
	
	private JFrame mainFrame;
	private JPanel buttonPanel1;
	private JPanel panel2;
	private JPanel panel3;
	private JPanel panel4;
	public JTextArea bArea;
	public String userName1=null;
	UserAction uaction = new UserAction();
	
	public MainView(String userName)
	{
		userName1=userName;
		JFrame.setDefaultLookAndFeelDecorated(true); 
		mainFrame = new JFrame("Book Management System");
		
		buttonPanel1 = new JPanel();
		JButton add = new JButton("add");
		JButton delete = new JButton("delete");
		JButton update = new JButton("update");
		JButton borrow = new JButton("borrow");
		JButton giveback = new JButton("giveback");
		
		panel2 = new JPanel();
		JTextField tname=new JTextField(12);
		JLabel lname = new JLabel("input Bookname:"); 
		JButton find = new JButton("find");
		
		panel3 =new JPanel();
		bArea =new JTextArea(20,40);
		bArea.setEditable(false);
		JScrollPane scrollPane =new JScrollPane(bArea);
		scrollPane.setHorizontalScrollBarPolicy( 
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollPane.setVerticalScrollBarPolicy( 
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED); 
		
		panel4 =new JPanel();
		JButton showall= new JButton("show all");
		
		buttonPanel1.add(add);
		buttonPanel1.add(delete);
		buttonPanel1.add(update);
		buttonPanel1.add(borrow);
		buttonPanel1.add(giveback);
		
		panel2.add(lname);
		panel2.add(tname);
		panel2.add(find);
		
		panel3.add(scrollPane);
		
		panel4.add(showall);
		
	
		mainFrame.add(buttonPanel1,BorderLayout.SOUTH);
		mainFrame.add(panel2,BorderLayout.NORTH );
		mainFrame.add(panel3, BorderLayout.CENTER);
		mainFrame.add(panel4,BorderLayout.WEST);
		mainFrame.pack();
		
		add.addActionListener(event ->{
			 AddAction m=new AddAction();
			 });
		
		update.addActionListener(event ->{
			 try {
				UpateAction m=new UpateAction();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 });
		
		delete.addActionListener(event ->{
			try {
				DeleteAction m=new DeleteAction();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 });
		
		showall.addActionListener(event ->{
			try {
				BookAction bookaction =new BookAction();
				Book book=new Book();
				List<Book> list = null;
				list=bookaction.query();
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		 });
		
		
		find.addActionListener(event ->{
			try {
					String name=tname.getText();
					BookAction bookaction =new BookAction();
					Book book=new Book();
					book=bookaction.find(name);
						bArea.append("****************************************************************************************"+
							"\n"+
							"id:"+String.valueOf(book.getId())+
							"  bookname:"+String.valueOf(book.getBookname())+
							"  author:"+String.valueOf(book.getAuthor())+
							"  updatetime:"+String.valueOf(book.getUpdate_time())+
							"  store:"+String.valueOf(book.getStore())+
							"\n"+
							"****************************************************************************************"+
							"\n");
					}
				 catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				});
			
			
		borrow.addActionListener(event ->{
			 try {
				BorrowbAction m=new BorrowbAction(userName1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 });
		
		giveback.addActionListener(event ->{
			 try {
				GivebAction m=new GivebAction(userName1);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 });
		
		
		mainFrame.setBounds(600,300, 550, 550);
		
		 mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 mainFrame.setVisible(true);
	}
	public static void main(String[] args) {
		//new MainView();

	}

}
