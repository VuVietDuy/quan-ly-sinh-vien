package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.LoginScreen;

public class LoginController implements ActionListener{
	private LoginScreen loginScreen;

	public LoginController(LoginScreen loginScreen) {
		this.loginScreen = loginScreen;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(loginScreen.getUser());

//		User existUser = UserDAO.getInstance().getUserByUsername(user.getUsername());
		
//		if (existUser.getPassword().equals(user.getPassword())) {
//			System.out.println("dang nhap thanh cong");
//		}
		
		
	}
	
	
}
