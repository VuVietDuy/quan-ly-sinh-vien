package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import db.JDBCUtil;
import model.Gender;
import model.Student;

public class StudentDAO implements DAO<Student>{
	
	private static final String INSERT_STUDENT = "INSERT INTO students (id, name, birthday, gender, address, major, class, created_at) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE_STUDENT = "UPDATE students SET id = ?, name = ?, birthday =?, gender = ?, address = ?, major = ?, class = ?, updated_at = ? WHERE id = ?";
	private static final String GET_ALL_STUDENTS = "SELECT * FROM students";
	private static final String DELETE_STUDENT = "DELETE FROM students WHERE id = ?";
	
	public static StudentDAO getInstance() {
		return new StudentDAO();
	}

	@Override
	public List<Student> getAll() {
		List<Student> res = new ArrayList<Student>();
		
		try {
			Connection connection = JDBCUtil.getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_STUDENTS);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				Student student = new Student();
				student.setMaSV(resultSet.getString("id"));
				student.setName(resultSet.getString("name"));
				student.setBirthday(resultSet.getString("birthday"));
				if (resultSet.getString("gender").equals("Nam")) 
					student.setGender(Gender.Nam);
				else 
					student.setGender(Gender.Nữ);
				student.setAddress(resultSet.getString("address"));
				student.setMajor(resultSet.getString("major"));
				student.set_class(resultSet.getString("class"));
				
				res.add(student);
			}
			
			
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public Student getById(String id) {
		Student res = new Student();
		
		try {
			Connection connection = JDBCUtil.getConnection();
			
			PreparedStatement preparedStatement = connection.prepareStatement(GET_ALL_STUDENTS);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			Student student = new Student();
			student.setMaSV(resultSet.getString("id"));
			student.setName(resultSet.getString("name"));
			student.setBirthday(resultSet.getString("birthday"));
			if (resultSet.getString("gender").equals("Nam")) 
				student.setGender(Gender.Nam);
			else 
				student.setGender(Gender.Nữ);
			student.setAddress(resultSet.getString("address"));
			student.setMajor(resultSet.getString("major"));
			student.set_class(resultSet.getString("class"));
				

			
			
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

	@Override
	public boolean insert(Student s) {
		boolean res = false;
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_STUDENT);
			
			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			
			preparedStatement.setString(1, s.getMaSV());
			preparedStatement.setString(2, s.getName());
			preparedStatement.setString(3, s.getBirthday());
			preparedStatement.setString(4, s.getGender() + "");
			preparedStatement.setString(5, s.getAddress());
			preparedStatement.setString(6, s.getMajor());
			preparedStatement.setString(7, s.get_class());
			preparedStatement.setTimestamp(8, currentTimestamp);
			
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
	public boolean update(String id, Student s) {
		boolean res = false;
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_STUDENT);
			
			Timestamp currentTimestamp = new Timestamp(System.currentTimeMillis());
			
			preparedStatement.setString(1, s.getMaSV());
			preparedStatement.setString(2, s.getName());
			preparedStatement.setString(3, s.getBirthday());
			preparedStatement.setString(4, s.getGender() + "");
			preparedStatement.setString(5, s.getAddress());
			preparedStatement.setString(6, s.getMajor());
			preparedStatement.setString(7, s.get_class());
			preparedStatement.setTimestamp(8, currentTimestamp);
			preparedStatement.setString(9, id);
			
			preparedStatement.executeUpdate();
			
			res = true;
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {

			e.printStackTrace();
			System.out.println("update student faild");
		}
		return res;
	}

	@Override
	public boolean delete(String id) {
		boolean res = false;
		
		try {
			Connection connection = JDBCUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(DELETE_STUDENT);
			
			preparedStatement.setString(1, id);
			
			preparedStatement.execute();
			res = true;
			
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("update student faild");
		}
		
		return res;
	}

	public List<Student> searchStudent(String id, String _class) {
		List<Student> res = new ArrayList<Student>();
		
		try {

			String SEARCH_STUDENT = GET_ALL_STUDENTS;
			
			if (!id.equals("") || !_class.equals("")) {
				SEARCH_STUDENT += " WHERE";
			}
			
			if (!id.equals("")) {
				SEARCH_STUDENT += " id = '" + id + "'";
				
			}
			
			if (!id.equals("") && !_class.equals("")) {
				SEARCH_STUDENT += " AND ";
			}
			
			if (!_class.equals("")) {
				SEARCH_STUDENT += " class = '" + _class + "'";
				
			}
			
			
			Connection connection = JDBCUtil.getConnection();
			
			Statement st = connection.createStatement();
			
			ResultSet resultSet = st.executeQuery(SEARCH_STUDENT);
			
			while (resultSet.next()) {
				Student student = new Student();
				student.setMaSV(resultSet.getString("id"));
				student.setName(resultSet.getString("name"));
				student.setBirthday(resultSet.getString("birthday"));
				if (resultSet.getString("gender").equals("Nam")) 
					student.setGender(Gender.Nam);
				else 
					student.setGender(Gender.Nữ);
				student.setAddress(resultSet.getString("address"));
				student.setMajor(resultSet.getString("major"));
				student.set_class(resultSet.getString("class"));
				
				res.add(student);
			}
			
			
			JDBCUtil.closeConnection(connection);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return res;
	}

}
