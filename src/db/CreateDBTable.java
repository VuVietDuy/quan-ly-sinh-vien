package db;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateDBTable {
	
	private final static String INIT_USERS_TABLE = "CREATE TABLE users (\r\n"
			+ "  id INTEGER PRIMARY KEY AUTO_INCREMENT,\r\n"
			+ "  username VARCHAR(255),\r\n"
			+ "  password VARCHAR(255),\r\n"
			+ "  created_at TIMESTAMP,\r\n"
			+ "  updated_at TIMESTAMP\r\n"
			+ ");";
	private final static String INIT_STUDENTS_TABLE = "CREATE TABLE students (\r\n"
			+ "  id CHAR(10) PRIMARY KEY,\r\n"
			+ "  name VARCHAR(255),\r\n"
			+ "  birthday VARCHAR(255),\r\n"
			+ "  gender VARCHAR(255),\r\n"
			+ "  address VARCHAR(255),\r\n"
			+ "  major VARCHAR(255),\r\n"
			+ "  class VARCHAR(255),\r\n"
			+ "  created_at TIMESTAMP,\r\n"
			+ "  updated_at TIMESTAMP\r\n"
			+ ");";
	private final static String INIT_CLASSES_TABLE = "CREATE TABLE classes (\r\n"
			+ "  id CHAR(11) PRIMARY KEY,\r\n"
			+ "  adviser VARCHAR(255),\r\n"
			+ "  major VARCHAR(255),\r\n"
			+ "  note VARCHAR(255),\r\n"
			+ "  created_at TIMESTAMP,\r\n"
			+ "  updated_at TIMESTAMP\r\n"
			+ ");";
	private final static String INIT_MAJORS_TABLE = "CREATE TABLE majors (\r\n"
			+ "  id VARCHAR(10) PRIMARY KEY,\r\n"
			+ "  name VARCHAR(255),\r\n"
			+ "  khoi_nganh VARCHAR(255),\r\n"
			+ "  note VARCHAR(255),\r\n"
			+ "  created_at TIMESTAMP,\r\n"
			+ "  updated_at TIMESTAMP\r\n"
			+ ");";
	private final static String INIT_INSTRUCTORS_TABLE = "CREATE TABLE instructors (\r\n"
			+ "  id VARCHAR(10) PRIMARY KEY,\r\n"
			+ "  name VARCHAR(255),\r\n"
			+ "  level VARCHAR(255),\r\n"
			+ "  nationality VARCHAR(255),\r\n"
			+ "  gender VARCHAR(255),\r\n"
			+ "  major VARCHAR(255),\r\n"
			+ "  created_at TIMESTAMP,\r\n"
			+ "  updated_at TIMESTAMP\r\n"
			+ ");";
	
	public static void main(String[] args) {
		try {
			Connection c = JDBCUtil.getConnection();
			Statement st = c.createStatement();
			
			st.execute(INIT_USERS_TABLE);
			st.execute(INIT_STUDENTS_TABLE);
			st.execute(INIT_CLASSES_TABLE);
			st.execute(INIT_MAJORS_TABLE);
			st.execute(INIT_INSTRUCTORS_TABLE);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
