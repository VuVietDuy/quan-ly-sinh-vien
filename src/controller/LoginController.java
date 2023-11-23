package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import dao.UserDAO;
import model.User;
import view.LoginScreen;
import view.MainScreen;

public class LoginController implements ActionListener{
	private LoginScreen loginScreen;

	public LoginController(LoginScreen loginScreen) {
		this.loginScreen = loginScreen;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		User user = loginScreen.getUser();

		User existUser = UserDAO.getInstance().getUserByUsername(user.getUsername());

		if (existUser.getUsername() != null ) {
			if (existUser.getPassword().equals(user.getPassword())) {
				System.out.println("Dang nhap thanh cong");
				MainScreen mainScreen = new MainScreen();
				mainScreen.openMainScreen();
			} else {
				System.out.println("Sai mat khau");
			}
		} else {
			System.out.println("Tai khoan khong ton tai");
		}
		
		
	}
	
	
}
