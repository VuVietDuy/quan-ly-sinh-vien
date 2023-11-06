package test;

import java.sql.Connection;

import db.JDBCUtil;

public class TestJDBCUtil {
	public static void main(String[] args) {
		Connection connection = JDBCUtil.getConnection();
		
		JDBCUtil.printInfo(connection);
		
		JDBCUtil.closeConnection(connection);
	}
}
