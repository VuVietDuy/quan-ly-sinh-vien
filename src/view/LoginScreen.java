package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.LoginController;
import model.User;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Color;

public class LoginScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usernameTF;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginScreen frame = new LoginScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void openWindow() {
		setVisible(true);
	}
	
	public void closeWindow() {
		setVisible(false);
	}

	/**
	 * Create the frame.
	 */
	public LoginScreen() {
		Font font = new Font("Tahoma", Font.PLAIN, 14);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 662, 419);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel loginTitleLb = new JLabel("Đăng nhập hệ thống");
		loginTitleLb.setFont(new Font("Tahoma", Font.BOLD, 16));
		loginTitleLb.setBounds(241, 55, 164, 42);
		contentPane.add(loginTitleLb);
		
		JLabel usernameLb = new JLabel("Tên đăng nhập");
		usernameLb.setFont(font);
		usernameLb.setBounds(101, 131, 93, 36);
		contentPane.add(usernameLb);
		
		JLabel passwordLb = new JLabel("Mật khẩu");
		passwordLb.setFont(font);
		passwordLb.setBounds(101, 191, 93, 36);
		contentPane.add(passwordLb);
		
		usernameTF = new JTextField();
		usernameTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		usernameTF.setBounds(241, 133, 300, 36);
		contentPane.add(usernameTF);
		usernameTF.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		passwordField.setBounds(241, 193, 300, 36);
		contentPane.add(passwordField);
		
		JButton loginBtn = new JButton("Đăng nhập");
		loginBtn.setBackground(new Color(255, 255, 255));
		loginBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		loginBtn.setBounds(224, 274, 198, 36);
		contentPane.add(loginBtn);
		
		LoginController l = new LoginController(this);
		loginBtn.addActionListener(l);
	}
	
	@SuppressWarnings("deprecation")
	public User getUser() {
		User user = new User(usernameTF.getText(), passwordField.getText());
		return user;
	}
}
