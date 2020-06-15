import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;


class Student1 extends JFrame
{
	Container c;
	JLabel lblAddRno, lblAddName, lblAddMark;
	JButton btnAddSave, btnAddBack;
	JTextField txtAddRno, txtAddName, txtAddMark;

	
	Student1 ()
	{
		c = getContentPane();
		c.setLayout(new FlowLayout());
		lblAddRno = new JLabel("Enter rno ");
		lblAddName = new JLabel("Enter name ");
		lblAddMark = new JLabel("Enter marks ");
		txtAddRno = new JTextField("10");
		txtAddName = new JTextField("20");
		txtAddMark = new JTextField("10");
		btnAddSave = new JButton("Save ");
		btnAddBack = new JButton("Back ");

		c.add(lblAddRno);	c.add(lblAddName);	c.add(lblAddMark);	c.add(txtAddRno);	
		c.add(txtAddName);	c.add(txtAddMark);	c.add(btnAddSave);	c.add(btnAddBack);
		

		ActionListener a1 = (ae)	->
		{
			Student a = new Student();
			dispose();
		};	
		btnAddBack.addActionListener(a1);
	
		ActionListener a2 = (ae) ->
		{
			int rno = Integer.parseInt(txtAddRno.getText());
			String name = txtAddName.getText();
			int mark =Integer.parseInt( txtAddMark.getText());
			new DbHandler().addStudent(rno, name,mark);
		};
		btnAddSave.addActionListener(a2);
		
		setTitle("Add Student ");
		setSize(300, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String args[])
	{
		Student1 a = new Student1();
	}
}
















































