package pl.miki.dao;


import java.sql.Connection;
import java.sql.DriverManager;

public class Test {

	public static void main(String[] args) {

		String jdbcUrl = "jdbc:mysql://127.0.0.1:3306/ecommerce?serverTimezone=UTC";
		String user = "root";
		String pass = "M1k2i3k4523698";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, pass);
			
			System.out.println("Connection successful!!!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		
	}

}