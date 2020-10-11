import java.sql.*;  

public class MySQLConnection {

	private Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException ex) {
			System.out.println("Unable to load MySQL Driver");
		}
	}
	
	public MySQLConnection()
	{
		try {	
			con = DriverManager.getConnection("jdbc:mysql://149.202.65.49:3306/mini_missions","Sasuke","w2yAYebiN3zwMAPb");
		}
		catch(Exception e){ System.out.println(e);} 
	}
	
	public void endConnection()
	{
		try {	
			con.close();
		}
		catch(SQLException e)
		{
			 System.out.println(e);
		}
	}
	
	public boolean checkUser(String username)
	{
		try {	
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT username FROM Accounts WHERE username='"+username+"'"); 
			if(rs.next())  
				return true;
			else return false;
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	public boolean getUser(String username, String password)
	{
		try {
			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("SELECT * FROM Accounts WHERE username='"+username+"' AND password='"+password+"'");
			while(rs.next())
			{
				System.out.println(rs.getString("username")+
				"  "+rs.getString("password")+
				"   "+ rs.getString("email")+
				"   "+		rs.getString("date"));
				return true;

			}
			return false;

		}
		catch(SQLException e)
		{
			System.out.println(e);
			return false;
		}
	}
	
	public boolean signUp(String username,String email, String password, int age, int passing, String degree)
	{
		try {
			Statement stmt=con.createStatement();  
			int countUpdated=stmt.executeUpdate(String.format("INSERT INTO Accounts (username,password,email,age,year,degree) VALUES ('%s','%s','%s',%d,%d,'%s')",username,password,email,age,passing,degree));
			if(countUpdated > 0)
				return true;
			else return false;
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return false;
		}
	}

	public String getEmail(String username)
	{
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM Accounts WHERE username='" + username + "'");
			if(rs.next())
			{
				return rs.getString("email");
			}
			return "Error ha 1";
		}
		catch(SQLException e)
		{
			System.out.println(e);
			return "Erorr ha";
		}
	}

}