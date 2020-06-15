import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class Student2 extends JFrame 
{
	Container c;
	TextArea taData;
	JButton  btnViewBack;
	
	Student2()
	{
		c = getContentPane();
		c.setLayout(new FlowLayout());
		taData = new TextArea(15,30);
		btnViewBack = new JButton("Back");
		c.add(taData);
		c.add(btnViewBack);
		String data = new DbHandler().viewStudent();
		taData.setText(data);
		ActionListener a1 = (ae) ->
		{
			Student s = new Student();
			dispose();
			
		};
		btnViewBack.addActionListener(a1);	
		

		setTitle("View Student ");
		setSize(300,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String args[])
	{	
		Student2 a = new Student2();
	}

}