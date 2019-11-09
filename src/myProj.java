import java.sql.*;
import java.util.Scanner;

public class myProj {
	
	public static void insertbook()
	{
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the name of the book ");
		String name=input.nextLine();
		System.out.print("Enter the id of the book ");
		String id=input.nextLine();
		System.out.print("Enter the related course ");
		String course=input.nextLine();
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/nsit?useTimezone=true&serverTimezone=UTC", "root", "");
			Statement stmt=con.createStatement();
			String query="insert into books(id,name,course) values('"+id+"','"+name+"','"+course+"');";
			int rs=stmt.executeUpdate(query);
			System.out.println("Book "+name+" inserted successfully");
		}
		catch(Exception e) 
		{System.err.println("Exception: "+e.getMessage());}
		finally
		{
			try
			{
				if(con!=null)
				con.close();
			}
			catch(SQLException e)
			{}
		}
	}
	
	public static void insertstudent()
	{
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the name of the student ");
		String name=input.nextLine();
		System.out.print("Enter the id of the student ");
		String id=input.nextLine();
		System.out.print("Enter the phone number of the student ");
		String phn_num=input.nextLine();
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/nsit?useTimezone=true&serverTimezone=UTC", "root", "");
			Statement stmt=con.createStatement();
			String query="insert into `student(1st oct)`(`id`,`name`,`number`) values('"+id+"','"+name+"','"+phn_num+"');";
			int rs=stmt.executeUpdate(query);
			System.out.println("Student "+name+" inserted successfully");
		}
		catch(Exception e) 
		{System.err.println("Exception: "+e.getMessage());}
		finally
		{	
			try
			{
				if(con!=null)
				con.close();
			}
			catch(SQLException e)
			{}
		}		
	}
	
	public static void issuebook()
	{
		String query;
		Scanner input=new Scanner(System.in);
		System.out.print("Enter the id of the student ");
		String sid=input.nextLine();		
		System.out.print("Enter the id of the book ");
		String bid=input.nextLine();
		System.out.print("Enter the issue date(YYYY-MM-DD) ");
		String issue_date=input.nextLine();
		System.out.print("Is the book returned(true/false) ");
		boolean ans=input.nextBoolean();
		if(ans==true)
		{
			System.out.print("Enter the return date(YYYY-MM-DD) ");
			Scanner temp=new Scanner(System.in);
			String return_date=temp.nextLine();
			query="INSERT INTO `issues`(`sid`, `bid`, `issue_date`, `returned`, `return_date`) VALUES('"+sid+"','"+bid+"','"+issue_date+"','"+"1"+"','"+return_date+"');";
		}
		else
		{
			query="INSERT INTO `issues`(`sid`, `bid`, `issue_date`, `returned`) VALUES('"+sid+"','"+bid+"','"+issue_date+"','0');";
		}
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/nsit?useTimezone=true&serverTimezone=UTC", "root", "");
			Statement stmt=con.createStatement();
			int rs=stmt.executeUpdate(query);
			System.out.println("Student "+sid+" and book "+bid+" inserted successfully");
		}
		catch(Exception e) 
		{System.err.println("Exception: "+e.getMessage());}
		finally
		{	
			try
			{
				if(con!=null)
				con.close();
			}
			catch(SQLException e)
			{}
		}		
	}
	
	public static void printbooks()
	{
		boolean anything=false;
		Scanner input=new Scanner(System.in);
		System.out.println("1.Print all books");
		System.out.println("2.Print a particular book");
		int op=input.nextInt();
		String query;
		if(op==1)
		{
			query="Select * from books";
		}
		else
		{
			System.out.println("Enter the book id to be displayed ");
			Scanner temp=new Scanner(System.in);
			String bid=temp.nextLine();
			query="Select * from books where id='"+bid+"';";
		}
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/nsit?useTimezone=true&serverTimezone=UTC", "root", "");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				anything=true;
				String name=rs.getString("name");
				int id=rs.getInt("id");
				String course=rs.getString("course");
				System.out.println("id:"+id+" name:"+name+" course:"+course);
			}
			if(anything==false) 
			{
				System.out.println("No books available");
			}
		}
		catch(Exception e) 
		{System.err.println("Exception: "+e.getMessage());}
		finally
		{	
			try
			{
				if(con!=null)
				con.close();
			}
			catch(SQLException e)
			{}
		}
	}
	
	public static void printstudents()
	{
		boolean anything=false;
		Scanner input=new Scanner(System.in);
		System.out.println("1.Print all students");
		System.out.println("2.Print a particular student");
		int op=input.nextInt();
		String query;
		if(op==1)
		{
			query="Select * from `student(1st oct)`";
		}
		else
		{
			System.out.println("Enter the student id to be displayed ");
			Scanner temp=new Scanner(System.in);
			String sid=temp.nextLine();
			query="Select * from `student(1st oct)` where id='"+sid+"';";
		}
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/nsit?useTimezone=true&serverTimezone=UTC", "root", "");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				anything=true;
				String name=rs.getString("name");
				int id=rs.getInt("id");
				int number=rs.getInt("number");
				System.out.println("id:"+id+" name:"+name+" number:"+number);
			}
			if(anything==false) 
			{
				System.out.println("No students available");
			}
		}
		catch(Exception e) 
		{System.err.println("Exception: "+e.getMessage());}
		finally
		{	
			try
			{
				if(con!=null)
				con.close();
			}
			catch(SQLException e)
			{}
		}	
	}
	
	public static void printissue()
	{
		boolean anything=false;
		Scanner input=new Scanner(System.in);
		System.out.println("1.Print all issued books");
		System.out.println("2.Print a particular issued book");
		int op=input.nextInt();
		String query;
		if(op==1)
		{
			query="Select * from `issues`";
		}
		else
		{
			Scanner temp=new Scanner(System.in);
			System.out.println("Enter the id of the issued book ");
			String bid=temp.nextLine();
			System.out.println("Enter the id of student who issued "+bid+" ");
			String sid=temp.nextLine(); 
			query="Select * from `issues` where sid='"+sid+"' AND bid='"+bid+"';";
		}
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/nsit?useTimezone=true&serverTimezone=UTC", "root", "");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				anything=true;
				String sid=rs.getString("sid");
				String bid=rs.getString("bid");
				String issue_date=rs.getString("issue_date");
				boolean returned=rs.getBoolean("returned");
				if(returned==true)
				{
					String return_date=rs.getString("return_date");
					System.out.println("student_id:"+sid+" book_id:"+bid+" issue_date:"+issue_date+" return_date:"+return_date);
				}
				else
				{
					System.out.println("student_id:"+sid+" book_id:"+bid+" issue_date:"+issue_date+" return_date:Not returned yet");
				}
			}
			if(anything==false) 
			{
				System.out.println("No such record of issue");
			}
		}
		catch(Exception e) 
		{System.err.println("Exception: "+e.getMessage());}
		finally
		{	
			try
			{
				if(con!=null)
				con.close();
			}
			catch(SQLException e)
			{}
		}			
	}
	
	public static void returnbook()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter the id of the issued book ");
		String bid=input.nextLine();
		System.out.println("Enter the id of student who issued "+bid+" ");
		String sid=input.nextLine();
		System.out.println("Enter the return date ");
		String return_date=input.nextLine();
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/nsit?useTimezone=true&serverTimezone=UTC", "root", "");
			Statement stmt=con.createStatement();
			String query="UPDATE issues SET `returned`='1',`return_date`='"+return_date+"' WHERE sid="+sid+" AND bid="+bid+";";
			int rs=stmt.executeUpdate(query);
			System.out.println("Book "+bid+" returned successfully by student "+sid+" on "+return_date);
		}
		catch(Exception e) 
		{System.err.println("Exception: "+e.getMessage());}
		finally
		{
			try
			{
				if(con!=null)
				con.close();
			}
			catch(SQLException e)
			{}
		}
	}
	
	public static void main(String args[])
	{
		int op;
		Scanner input=new Scanner(System.in);
		while(true)
		{
			System.out.println("1.Insert book");
			System.out.println("2.Insert student");
			System.out.println("3.Issue a book");
			System.out.println("4.Print books");
			System.out.println("5.Print students");
			System.out.println("6.Print issued books");
			System.out.println("7.Return a book");
			System.out.println("else quit");
			op=input.nextInt();
			if(op==1)
			{
				insertbook();
			}
			else if(op==2)
			{
				insertstudent();
			}
			else if(op==3)
			{
				issuebook();
			}
			else if(op==4)
			{
				printbooks();
			}
			else if(op==5)
			{
				printstudents();
			}
			else if(op==6)
			{
				printissue();
			}
			else if(op==7)
			{
				returnbook();
			}
			else
			{break;}
		}
		System.out.println("BYE");
	}
}
