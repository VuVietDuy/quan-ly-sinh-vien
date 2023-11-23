package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import view.LoginScreen;
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
		} else if (option.equals("Ngành")) {
			this.menu.setMajorManagementView();
		} else if (option.equals("Đăng xuất")) {
			this.menu.closeWindow();
            LoginScreen loginScreen = new LoginScreen();
            loginScreen.openWindow();
		} else if (option.equals("Export")){
			JTable table = this.menu.getTable();
			JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Specify a file to save");
            int userSelection = fileChooser.showSaveDialog(null);
            if (userSelection == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath() + ".xlsx";
                Util.exportToExcel((DefaultTableModel) table.getModel(), filePath);
                JOptionPane.showMessageDialog(null, "Exported to Excel successfully!");
            }
		}
	}

}
