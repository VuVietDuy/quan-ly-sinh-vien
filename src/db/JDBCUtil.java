package db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class JDBCUtil {
	
	public static Connection getConnection() {
		Connection c = null;
		
		try {
			String url = "jdbc:mySQL://localhost:3306/quan_ly_sinh_vien";
			String username = "root";
			String password = "vuvietduy1234";
			
			c = DriverManager.getConnection(url, username, password);
			
			DriverManager.registerDriver(new Driver());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	public static void closeConnection(Connection c) {
		try {
			if(c != null) {
				c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void printInfo(Connection c) {
		try {
			if (c != null) {
				DatabaseMetaData m = c.getMetaData();
				System.out.println(m.getDatabaseProductName());
				System.out.println(m.getDatabaseProductVersion());
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
