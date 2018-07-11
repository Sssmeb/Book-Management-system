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

public class DeleteAction {
	private JFrame delFrame;
	private JPanel delPanel;
	private JButton back;
	private JPanel showPanel;
	private JTextArea bArea;
	Book book=new Book();
	BookAction action =new BookAction();
	
	public DeleteAction() throws Exception
	{
		JFrame.setDefaultLookAndFeelDecorated(true); 
		delFrame = new JFrame("Delete Book");
		delPanel = new JPanel();
		JButton back = new JButton("back");
		JLabel lid = new JLabel("input id:"); 
		JTextField iid=new JTextField(20);
		
		delFrame.add(delPanel);
		delPanel.add(back);
		delPanel.add(lid);
		delPanel.add(iid);
		
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
		
		
		iid.addActionListener(new ActionListener()
		 {
			 public void actionPerformed(ActionEvent e)
			 {
				 int id =Integer.valueOf(iid.getText());
				 try {
					action.del(id);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				 delFrame.setVisible(false);
			 }
		 });
		
		back.addActionListener(event ->{
			 delFrame.setVisible(false);
			 });
		 
		 delFrame.add(delPanel,BorderLayout.NORTH);
		 delFrame.add(back,BorderLayout.SOUTH );
		 delFrame.add(showPanel,BorderLayout.CENTER);
		
		 delFrame.setBounds(600, 300, 500, 500);
		 delPanel.setBounds(200, 200, 200, 200);
		 
		 //delFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 delFrame.setVisible(true);
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//new DeleteAction();
	}

}
