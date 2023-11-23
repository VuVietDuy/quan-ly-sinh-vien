package test;

import dao.UserDAO;

public class TestUserDAO {
	public static void main(String[] args) {
		UserDAO.getInstance().getAllUser();
		
	}
}
