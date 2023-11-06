package test;

import dao.UserDAO;
import model.User;

public class TestUserDAO {
	public static void main(String[] args) {
		UserDAO.getInstance().getAllUser();
		
	}
}
