package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import db.JDBCUtil;
import model.Major;

public class MajorDAO implements DAO<Major>{
	
	private static final String INSERT_MAJOR = "INSERT INTO majors (id, name, khoi_nganh, note, created_at) VALUES ( ?, ?, ?, ?, ?)";
	private static final String UPDATE_MAJOR = "UPDATE majors SET id = ?, name = ?, khoi_nganh =?, note = ?, updated_at = ? WHERE id = ?";
	private static final String GET_ALL_MAJORS = "SELECT * FROM majors";
	private static final String DELETE_MAJOR = "DELETE FROM majors WHERE id = ?";

	@Override
	public List<Major> getAll() {
		List<Major> res = new ArrayList<Major>();
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_MAJORS);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Major m = new Major();
				
				m.setId(resultSet.getString("id"));
				m.setName(resultSet.getString("name"));
				m.setKhoiNganh(resultSet.getString("khoi_nganh"));
				m.setNote(resultSet.getString("note"));
				
				res.add(m);
			}
			
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public Major getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Major m) {
		boolean res = false;
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_MAJOR);
			
			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			
			preparedStatement.setString(1, m.getId());
			preparedStatement.setString(2, m.getName());
			preparedStatement.setString(3, m.getKhoiNganh());
			preparedStatement.setString(4, m.getNote());
			preparedStatement.setTimestamp(5, currentTimestamp);
			
			preparedStatement.execute();
			
			res = true;
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insert major faild");
		}
		return res;
	}

	@Override
	public boolean update(String id, Major m) {
		boolean res = false;
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_MAJOR);
			
			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			
			preparedStatement.setString(1, m.getId());
			preparedStatement.setString(2, m.getName());
			preparedStatement.setString(3, m.getKhoiNganh());
			preparedStatement.setString(4, m.getNote());
			preparedStatement.setTimestamp(5, currentTimestamp);
			preparedStatement.setString(6, id);
			
			preparedStatement.execute();
			
			res = true;
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("insert major faild");
		}
		return res;
	}

	@Override
	public boolean delete(String id) {
		boolean res = false;
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_MAJOR);
			
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

	public static MajorDAO getInstance() {
		// TODO Auto-generated method stub
		return new MajorDAO();
	}

}
