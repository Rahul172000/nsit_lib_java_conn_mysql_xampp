import java.sql.*;
public class testing_sql_conn 
{
	public static void main(String args[]) 
	{
		Connection con=null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/nsit?useTimezone=true&serverTimezone=UTC", "root", "");
			if(!con.isClosed())
				System.out.println("Successfully connected to MySQL server...");
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select * from student");
			while(rs.next())
			{
				String name=rs.getString("Name");
				int id=rs.getInt("id");
				System.out.println(name);
				System.out.println(id);
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
}