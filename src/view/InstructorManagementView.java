package view;

import java.awt.Font;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.Instructor;
import model._Class;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class InstructorManagementView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField instructorIdInputTF;
	private JTextField nameInputTF;
	private JTextField nationalityInputLb;
	private String option;

	/**
	 * Create the panel.
	 */
	public InstructorManagementView() {
		
		setLayout(null);
		
		JPanel inputPane = new JPanel();
		inputPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		inputPane.setBounds(10, 11, 764, 200);
		add(inputPane);
		inputPane.setLayout(null);
		
		JButton createBtn = new JButton("Thêm +");
		createBtn.setForeground(new Color(255, 255, 255));
		createBtn.setBackground(new Color(0, 128, 0));
		createBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		createBtn.setBounds(664, 13, 90, 32);
		inputPane.add(createBtn);
		
		JButton updateBtn = new JButton("Sửa");
		updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateBtn.setBounds(664, 58, 90, 32);
		inputPane.add(updateBtn);
		
		JButton deleteBtn = new JButton("Xoá");
		deleteBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteBtn.setBounds(664, 103, 90, 32);
		inputPane.add(deleteBtn);
		
		instructorIdInputTF = new JTextField();
		instructorIdInputTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		instructorIdInputTF.setBounds(102, 14, 198, 32);
		inputPane.add(instructorIdInputTF);
		instructorIdInputTF.setColumns(10);
		
		JLabel instructorIdLb = new JLabel("Mã giảng viên");
		instructorIdLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		instructorIdLb.setBounds(10, 14, 90, 32);
		inputPane.add(instructorIdLb);
		
		JLabel nameLb = new JLabel("Họ và tên");
		nameLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLb.setBounds(10, 60, 90, 32);
		inputPane.add(nameLb);
		
		nameInputTF = new JTextField();
		nameInputTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameInputTF.setColumns(10);
		nameInputTF.setBounds(102, 60, 198, 32);
		inputPane.add(nameInputTF);
		
		JLabel levelLb = new JLabel("Trình độ");
		levelLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		levelLb.setBounds(10, 106, 90, 32);
		inputPane.add(levelLb);
		
		String[] items = {"Thạc sĩ", "Tiến sĩ" ,"Phó giáo sư tiến sĩ"};
		JComboBox<String> levelCB = new JComboBox<>(items);
		levelCB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		levelCB.setBounds(102, 106, 198, 32);
		inputPane.add(levelCB);
		
		JLabel nationalityLb = new JLabel("Quốc tịch");
		nationalityLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nationalityLb.setBounds(10, 152, 90, 32);
		inputPane.add(nationalityLb);
		
		JLabel genderLB = new JLabel("Giới tính");
		genderLB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		genderLB.setBounds(337, 13, 66, 32);
		inputPane.add(genderLB);
		
		JLabel majorLb = new JLabel("Khoa");
		majorLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		majorLb.setBounds(337, 59, 66, 32);
		inputPane.add(majorLb);
		
		nationalityInputLb = new JTextField();
		nationalityInputLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nationalityInputLb.setColumns(10);
		nationalityInputLb.setBounds(102, 152, 198, 32);
		inputPane.add(nationalityInputLb);
		
		JRadioButton ManRdbtn = new JRadioButton("Nam");
		ManRdbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		ManRdbtn.setBounds(421, 13, 53, 32);
		inputPane.add(ManRdbtn);
		
		JRadioButton womenRdbtn = new JRadioButton("Nữ");
		womenRdbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		womenRdbtn.setBounds(490, 13, 53, 32);
		inputPane.add(womenRdbtn);
		
		JComboBox majorInputCB = new JComboBox();
		majorInputCB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		majorInputCB.setBounds(413, 59, 198, 32);
		inputPane.add(majorInputCB);
		
		JButton saveBtn = new JButton("Lưu");
		saveBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		saveBtn.setBounds(413, 152, 90, 32);
		inputPane.add(saveBtn);
		
		JButton exitBtn = new JButton("Huỷ bỏ");
		exitBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		exitBtn.setBounds(521, 152, 90, 32);
		inputPane.add(exitBtn);
		
		JPanel tablePane = new JPanel();
		tablePane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tablePane.setBounds(10, 222, 764, 355);
		add(tablePane);
		tablePane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 41, 744, 303);
		tablePane.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Stt", "Mã giảng viên", "Họ và tên", "Trình độ", "Quốc tịch", "Giới tính", "Khoa"
			}
		));
		table.setRowHeight(24);
		table.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 15 ));
		scrollPane.setViewportView(table);
		
		JLabel InstructorListLb = new JLabel("Danh sách giảng viên");
		InstructorListLb.setBounds(10, 11, 139, 27);
		tablePane.add(InstructorListLb);
		InstructorListLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}

	public void exitForm() {
		// TODO Auto-generated method stub
		
	}

	public void setOption(String option) {
		// TODO Auto-generated method stub
		
	}

	public void addDataIntoTable() {
		// TODO Auto-generated method stub
		
	}

	public Instructor getDataInput() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean displayInfo() {
		// TODO Auto-generated method stub
		return false;
	}
}
