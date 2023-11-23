package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import db.JDBCUtil;
import model.User;

public class UserDAO {
	
	public static UserDAO getInstance() {
		return new UserDAO();
	}
	
	private static final String GET_USER_BY_USERNAME = "SELECT * FROM users WHERE username = ?";
	private static final String GET_ALL_USER = "SELECT * FROM users";
	
	public User getUserByUsername(String username) {
		
		User user = new User();
		
		try {
			Connection c = JDBCUtil.getConnection();
			PreparedStatement pre = c.prepareStatement(GET_USER_BY_USERNAME);
			pre.setString(1, username);
			
			ResultSet result = pre.executeQuery();
			
			while (result.next()) {
				user.setUsername(result.getString("username"));
				user.setPassword(result.getString("password"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error");
		}
		return user;
	}
	
	public void getAllUser() {
		try {
			Connection c = JDBCUtil.getConnection();
			PreparedStatement pre = c.prepareStatement(GET_ALL_USER);
			
			ResultSet result = pre.executeQuery();
			
			while (result.next()) {
				System.out.println(result.getString("username"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("error");
		}
	}
}
