import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

class Student extends JFrame 
{
	Container c;
	JButton btnAdd, btnView, btnUpdate, btnDel;
	
	Student()
	{
		c = getContentPane();
		c.setLayout(new FlowLayout());
		btnAdd = new JButton("Add");
		btnView = new JButton("View");
		btnUpdate = new JButton("Update");
		btnDel = new JButton("Delete");
		c.add(btnAdd);
		c.add(btnView);
		c.add(btnUpdate);
		c.add(btnDel);

		ActionListener a1 = (ae) ->
		{
			Student1 a = new Student1();
			dispose();
		};
		btnAdd.addActionListener(a1);
			
		ActionListener a2 = (ae) ->
		{
			Student2 a = new Student2();
			dispose();
		};
		btnView.addActionListener(a2);
		
                ActionListener a3 = (ae) ->
		{
			Student3 a = new Student3();
			dispose();
		};
		btnUpdate.addActionListener(a3);

	
		ActionListener a4 = (ae) ->
		{
			Student4 a = new Student4();
			dispose();
		};
		btnDel.addActionListener(a4);
		

setTitle("Student App");
		setSize(300,500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String args[])
	{
		Student s = new Student();
	}
}






class DbHandler
{
	public void addStudent(int rno, String name, int mark)
	{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe", "system", "abc123");
			String sql = " insert into project_student values(?,?,?)";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(1,rno);
			pst.setString(2,name);
			pst.setInt(3,mark);
			long rid = pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(), rid + " record inserted");
			conn.close();
		}
		catch(SQLException se)
		{
			System.out.println("issue" +se);
			JOptionPane.showMessageDialog(new JDialog(), "issue" +se);
		}
		
	}
	


	public String viewStudent()
	{
		StringBuffer sb = new StringBuffer();
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe", "system", "abc123");
			String sql = "select * from  project_student ";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);		
			while(rs.next())
			{
				int rno = rs.getInt(1);
				String name = rs.getString(2);
				int mark = rs.getInt(3);
				System.out.println(rno+ " " +name+ " "+mark);
				sb.append(rno + " " +name+ " "+mark+ "\n");
			}
			rs.close();
			conn.close();
		}
		catch(SQLException se)
		{
			System.out.println("issue" +se);
		}
		return sb.toString();
	}
public void delStudent(int rno)
	{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe", "system", "abc123");
                        
			String sql = " delete from project_student where rno=?";
			PreparedStatement pst = conn.prepareStatement(sql);
pst.setInt(1,rno);			
long rid = pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(), rid + " record deleted");
			conn.close();
		}
		catch(SQLException se)
		{
			System.out.println("issue" +se);
			JOptionPane.showMessageDialog(new JDialog(), "issue" +se);
		}
		
	}
	
public void updateStudent(int rno, String name, int mark)
	{
		try
		{
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
			Connection conn = DriverManager.getConnection
			("jdbc:oracle:thin:@localhost:1521:xe", "system", "abc123");
			String sql = " update project_student set name = ? , mark = ? where rno = ? ";
			PreparedStatement pst = conn.prepareStatement(sql);
			pst.setInt(3,rno);
			pst.setString(1,name);
			pst.setInt(2,mark);
			long rid = pst.executeUpdate();
			JOptionPane.showMessageDialog(new JDialog(), rid + " record updated");
			conn.close();
		}
		catch(SQLException se)
		{
			System.out.println("issue" +se);
			JOptionPane.showMessageDialog(new JDialog(), "issue" +se);
		}
		
	}




}













