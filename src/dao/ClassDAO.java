package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import db.JDBCUtil;
import model._Class;

public class ClassDAO implements DAO<_Class>{
	
	private static final String INSERT_CLASS = "INSERT INTO classes (id, adviser, major, note, created_at) VALUES ( ?, ?, ?, ?, ?)";
	private static final String UPDATE_CLASS = "UPDATE classes SET id = ?, adviser = ?, major =?, note = ?, updated_at = ? WHERE id = ?";
	private static final String GET_ALL_CLASSES = "SELECT * FROM classes";
	private static final String DELETE_CLASS = "DELETE FROM classes WHERE id = ?";
	
	public static ClassDAO getInstance() {
		return new ClassDAO();
	}

	@Override
	public List<_Class> getAll() {
		List<_Class> res = new ArrayList<_Class>();
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_CLASSES);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				_Class c = new _Class();
				
				c.setId(resultSet.getString("id"));
				c.setAdviser(resultSet.getString("adviser"));
				c.setMajor(resultSet.getString("major"));
				c.setNote(resultSet.getString("note"));
				
				res.add(c);
			}
			
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public boolean insert(_Class c) {
		// TODO Auto-generated method stub
		boolean res = false;
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CLASS);
			
			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			
			preparedStatement.setString(1, c.getId());
			preparedStatement.setString(2, c.getAdviser());
			preparedStatement.setString(3, c.getMajor());
			preparedStatement.setString(4, c.getNote());
			preparedStatement.setTimestamp(5, currentTimestamp);
			
			preparedStatement.execute();
			
			res = true;
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insert class faild");
		}
		return res;
	}

	@Override
	public boolean update(String id,_Class c) {
		boolean res = false;
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CLASS);
			
			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			
			preparedStatement.setString(1, c.getId());
			preparedStatement.setString(2, c.getAdviser());
			preparedStatement.setString(3, c.getMajor());
			preparedStatement.setString(4, c.getNote());
			preparedStatement.setTimestamp(5, currentTimestamp);
			preparedStatement.setString(6, id);
			
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
	public _Class getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(String id) {
		boolean res = false;
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CLASS);
			
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
