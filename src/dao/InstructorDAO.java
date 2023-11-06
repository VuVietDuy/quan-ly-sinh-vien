package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import db.JDBCUtil;
import model.Instructor;

public class InstructorDAO implements DAO<Instructor>{
	
	private static final String INSERT_INSTRUCTOR = "INSERT INTO instructors (id, name, level, nationality, gender, major, created_at) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_INSTRUCTOR = "UPDATE instructors SET id = ?, name = ?, level = ?, nationality = ?, gender = ?, major = ?, updated_at = ? WHERE id = ?";
	private static final String GET_ALL_INSTRUCTORS = "SELECT * FROM instructors";
	private static final String DELETE_INSTRUCTOR = "DELETE FROM instructors WHERE id = ?";
	
	public static InstructorDAO getInstance() {
		return new InstructorDAO();
	}

	@Override
	public List<Instructor> getAll() {
		List<Instructor> res = new ArrayList<Instructor>();
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_INSTRUCTORS);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Instructor t = new Instructor();
				
				t.setId(resultSet.getString("id"));
				t.setName(resultSet.getString("name"));
				t.setLevel(resultSet.getString("level"));
				t.setNationality(resultSet.getString("nationality"));
				t.setGender(resultSet.getString("gender"));
				t.setMajor(resultSet.getString("major"));
				
				res.add(t);
			}
			
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public Instructor getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Instructor t) {
		boolean res = false;
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INSTRUCTOR);
			
			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			
			preparedStatement.setString(1, t.getId());
			preparedStatement.setString(2, t.getName());
			preparedStatement.setString(3, t.getLevel());
			preparedStatement.setString(4, t.getNationality());
			preparedStatement.setString(5, t.getGender());
			preparedStatement.setString(6, t.getMajor());
			preparedStatement.setTimestamp(7, currentTimestamp);
			
			preparedStatement.execute();
			
			res = true;
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insert instructor faild");
		}
		return res;
	}

	@Override
	public boolean update(String id, Instructor t) {
		boolean res = false;
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_INSTRUCTOR);
			
			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			
			preparedStatement.setString(1, t.getId());
			preparedStatement.setString(2, t.getName());
			preparedStatement.setString(3, t.getLevel());
			preparedStatement.setString(4, t.getNationality());
			preparedStatement.setString(5, t.getGender());
			preparedStatement.setString(6, t.getMajor());
			preparedStatement.setTimestamp(7, currentTimestamp);
			preparedStatement.setString(8, id);
			
			preparedStatement.executeUpdate();
			
			res = true;
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("update class faild");
		}
		return res;
	}

	@Override
	public boolean delete(String id) {
		boolean res = false;
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_INSTRUCTOR);
			
			preparedStatement.setString(1, id);
			
			preparedStatement.execute();
			res = true;
			
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

}
