package dao;

import java.util.List;

import model.Instructor;

public class InstructorDAO implements DAO<Instructor>{
	
	public static InstructorDAO getInstance() {
		return new InstructorDAO();
	}

	@Override
	public List<Instructor> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Instructor getById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(Instructor t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(String id, Instructor t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		// TODO Auto-generated method stub
		return false;
	}

}
