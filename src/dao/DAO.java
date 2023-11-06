package dao;

import java.util.List;

public interface DAO<T> {
	public List<T> getAll();
	public T getById(String id);
	public boolean insert(T t);
	public boolean update(String id,T t);
	public boolean delete(String id);
}

/*
 * users
 * students
 * majors
 * classes
 * instructors
 * */
