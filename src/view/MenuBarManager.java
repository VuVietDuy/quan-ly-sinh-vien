package view;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import controller.MenuBarController;

public class MenuBarManager extends JMenuBar{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menuBar;
    private MainScreen mainScreen;

    public MenuBarManager(MainScreen mainScreen) {
    	
    	this.mainScreen = mainScreen;
        menuBar = new JMenuBar();
        ActionListener menuBarLisener = new MenuBarController(this);
        
        JMenu systemMenu = new JMenu("Hệ thống");
		systemMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(systemMenu);
		
		JMenuItem homeMenu = new JMenuItem("Trang chủ");
		homeMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		systemMenu.add(homeMenu);
		homeMenu.addActionListener(menuBarLisener);
		
		JSeparator separator = new JSeparator();
		systemMenu.add(separator);
		
		JMenuItem logoutMenu = new JMenuItem("Đăng xuất");
		logoutMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		systemMenu.add(logoutMenu);
		logoutMenu.addActionListener(menuBarLisener);
		
		JMenu featuresMenu = new JMenu("Tính năng");
		featuresMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		menuBar.add(featuresMenu);
		
		JMenuItem studentMenu = new JMenuItem("Quản lý sinh viên");
		studentMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		featuresMenu.add(studentMenu);
		studentMenu.addActionListener(menuBarLisener);
		
		JMenuItem classMenu = new JMenuItem("Quản lý lớp hành chính");
		classMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		featuresMenu.add(classMenu);
		classMenu.addActionListener(menuBarLisener);
		
		JMenuItem instructorMenu = new JMenuItem("Giảng viên");
		instructorMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		featuresMenu.add(instructorMenu);
		instructorMenu.addActionListener(menuBarLisener);
		
		JMenuItem majorMenu = new JMenuItem("Khoa");
		majorMenu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		featuresMenu.add(majorMenu);
		majorMenu.addActionListener(menuBarLisener);
		
		menuBar.add(systemMenu);
		menuBar.add(featuresMenu);
    }

    public JMenuBar getMenuBar() {
        return menuBar;
    }
    
    public void setClassManagementView() {
    	this.mainScreen.setClassManagementView();
    }
    
    public void setStudentManagementView() {
    	this.mainScreen.setStudentManagementView();
    }
    
    public void setMajorManagementView() {
        this.mainScreen.setMajorManagementView();
    }
    
    public void setInstructorManagementView() {
        this.mainScreen.setInstructorManagementView();
    }
    
    public void closeWindow() {
    	mainScreen.closeJWindow();
    }
}
