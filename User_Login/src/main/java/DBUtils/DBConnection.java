package DBUtils;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	
	public static Connection connect() {
		
		Connection con = null;
		String username= "root";
		String password = "";
		String dbUrl = "jdbc:mysql://localhost:3306/adminroles";

		try {	
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(dbUrl, username, password);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
		
	}

}