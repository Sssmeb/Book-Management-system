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

import com.caorunjia.BMS.entity.Borrow;
import com.caorunjia.BMS.entity.User;
import com.caorunjia.BMS.service.BorrowAction;
import com.caorunjia.BMS.service.UserAction;

public class GivebAction {
	private JFrame givebFrame;
	private JPanel givebPanel;
	private JButton back;
	private JPanel showPanel;
	private JTextArea bArea;
	private int bookid=0;
	private int userid=0;
	public String userName1=null;
	Borrow borrow=new Borrow();
	BorrowAction action =new BorrowAction();
	UserAction uaction =new UserAction();
	
	public GivebAction(String userName) throws Exception
	{
		userName1=userName;
		userid=(uaction.find(userName1)).getId();
		
		JFrame.setDefaultLookAndFeelDecorated(true); 
		givebFrame = new JFrame("Return book");
		givebPanel = new JPanel();
		JButton back = new JButton("back");
		/*JLabel lid2 = new JLabel("input your id:"); 
		JTextField iid2=new JTextField(20);*/
		JLabel lid = new JLabel("input bookid:"); 
		JTextField iid=new JTextField(20);

		givebFrame.add(givebPanel);
		givebPanel.add(back);
		givebPanel.add(lid);
		givebPanel.add(iid);
		/*givebPanel.add(lid2);
		givebPanel.add(iid2);*/
		
		showPanel = new JPanel();                                       //显示已借的书、用户
		bArea =new JTextArea(20,40);
		bArea.setEditable(false);
		JScrollPane scrollPane =new JScrollPane(bArea);
		scrollPane.setHorizontalScrollBarPolicy( 
		JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); 
		scrollPane.setVerticalScrollBarPolicy( 
		JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		showPanel.add(scrollPane);
		List<Borrow> list = null;
		list=action.query(userid);
		bArea.append("All record:"+"\n"+"\n");
		for(Borrow g:list)
		{
		bArea.append("id:"+String.valueOf(g.getId())+
				"  userid:"+String.valueOf(g.getUserid())+
				"  bookid:"+String.valueOf(g.getBookid())+
				"  borrowtime:"+String.valueOf(g.getBorrow_time())+
				"\n"+
				"-----------------------------------------------------------------------------------------------------------"+
				"\n");
		}
		
		bArea.setLineWrap(true);
		
		/*List<User> ulist = null;                                //显示对应id
		ulist=uaction.query();
		bArea.append("Find your userid:"+"\n"+"\n");
		for(User g:ulist)
		{
		bArea.append("id:"+String.valueOf(g.getId())+
				"  userName:"+String.valueOf(g.getuserName())+
				"\n"+
				"-----------------------------------------------------------------------------------------------------------"+
				"\n");
		}*/
		
		
		
		
		iid.addActionListener(new ActionListener()
		 {
			 public void actionPerformed(ActionEvent e)
			 {
				  bookid =Integer.valueOf(iid.getText());
				  try {
					action.del(userid,bookid);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  givebFrame.setVisible(false);
			 }
		 });

		/*iid2.addActionListener(new ActionListener()
		 {
			 public void actionPerformed(ActionEvent e)
			 {
				  bookid =Integer.valueOf(iid2.getText());
				  try {
					action.del(userid,bookid);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  givebFrame.setVisible(false);
				  
			 }
		 });*/
		
		back.addActionListener(event ->{
			givebFrame.setVisible(false);
			 });
		 
		givebFrame.add(givebPanel);
		givebFrame.add(back );
		givebFrame.add(showPanel);
		givebFrame.setLayout(new FlowLayout());
		
		
		
		givebFrame.setBounds(600, 300, 700, 500);
		givebPanel.setBounds(200, 200, 200, 200);
		 
		givebFrame.setVisible(true);
		
		
	}
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//new GivebAction();
	}
}
