package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MenuBarManager;

public class MenuBarController implements ActionListener{
	
	private MenuBarManager menu;

	public MenuBarController(MenuBarManager menu) {
		this.menu = menu;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String option = e.getActionCommand();
		
		
		if (option.equals("Quản lý lớp hành chính")) {
			this.menu.setClassManagementView();
		} else if (option.equals("Quản lý sinh viên")) {
			this.menu.setStudentManagementView();
		} else if (option.equals("Giảng viên")) {
			this.menu.setInstructorManagementView();
		} else if (option.equals("Khoa")) {
			this.menu.setMajorManagementView();
		} else if (option.equals("Đăng xuất")) {
			this.menu.closeWindow();
		}
	}

}
