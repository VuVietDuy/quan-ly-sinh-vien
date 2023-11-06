package view;

import java.awt.Font;
import java.util.List;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import controller.InstructorController;
import controller.Util;
import model.Instructor;

public class InstructorManagementView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField instructorIdInputTF;
	private JTextField nameInputTF;
	private JTextField nationalityInputLb;
	private String option;
	private JButton saveBtn;
	private JComboBox<String> levelCB;
	private JRadioButton manRdbtn;
	private JRadioButton womenRdbtn;
	private JComboBox<String> majorInputCB;
	private InstructorController instructorController;
	/**
	 * Create the panel.
	 */
	public InstructorManagementView() {
		instructorController = new InstructorController(this);
		
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
		createBtn.addActionListener(instructorController);
		
		JButton updateBtn = new JButton("Sửa");
		updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateBtn.setBounds(664, 58, 90, 32);
		inputPane.add(updateBtn);
		updateBtn.addActionListener(instructorController);
		
		JButton deleteBtn = new JButton("Xoá");
		deleteBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteBtn.setBounds(664, 103, 90, 32);
		deleteBtn.addActionListener(instructorController);
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
		levelCB = new JComboBox<>(items);
		levelCB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		levelCB.setBounds(102, 106, 198, 32);
		inputPane.add(levelCB);
		levelCB.setSelectedIndex(-1);
		
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
		
		manRdbtn = new JRadioButton("Nam");
		manRdbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		manRdbtn.setBounds(421, 13, 53, 32);
		inputPane.add(manRdbtn);
		
		womenRdbtn = new JRadioButton("Nữ");
		womenRdbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		womenRdbtn.setBounds(490, 13, 53, 32);
		inputPane.add(womenRdbtn);
		
		ButtonGroup btnG = new ButtonGroup();
		btnG.add(this.manRdbtn);
		btnG.add(this.womenRdbtn);
		
		String[] itemsMajorCB = Util.getAllMajorFromDb();
		majorInputCB = new JComboBox<>(itemsMajorCB);
		majorInputCB.setSelectedIndex(-1);
		majorInputCB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		majorInputCB.setBounds(413, 59, 198, 32);
		inputPane.add(majorInputCB);
		
		saveBtn = new JButton("Thêm");
		saveBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		saveBtn.setBounds(413, 152, 90, 32);
		inputPane.add(saveBtn);
		saveBtn.addActionListener(instructorController);
		
		JButton exitBtn = new JButton("Huỷ bỏ");
		exitBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		exitBtn.setBounds(521, 152, 90, 32);
		inputPane.add(exitBtn);
		exitBtn.addActionListener(instructorController);
		
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
		this.addDataIntoTable();
		
		JLabel InstructorListLb = new JLabel("Danh sách giảng viên");
		InstructorListLb.setBounds(10, 11, 139, 27);
		tablePane.add(InstructorListLb);
		InstructorListLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}

	public void exitForm() {
		this.instructorIdInputTF.setText("");
		this.nameInputTF.setText("");
		this.levelCB.setSelectedIndex(-1);
		this.nationalityInputLb.setText("");
		this.manRdbtn.setSelected(false);
		this.womenRdbtn.setSelected(false);
		this.majorInputCB.setSelectedIndex(-1);
		
	}

	public void setOption(String option) {
		this.option = option;
		this.rePaintBtn();
		/*
		 * DEFAULT_OPTION
		 * CREATE_OPTION
		 * UPDATE_OPTION
		 */
	}
	
	public String getOption() {
		return option;
	}

	public void addDataIntoTable() {
		List<Instructor> instructors = this.instructorController.getDataFromDb();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		int stt = 1;
		while (model.getRowCount() > 0) {
			model.removeRow(0);
        }
		for (Instructor i : instructors) {
			model.addRow(new Object[] {
					stt,
					i.getId(),
					i.getName(),
					i.getLevel(),
					i.getNationality(),
					i.getGender(),
					i.getMajor(),
			});
			stt++;
		}
		table.revalidate();
		table.repaint();
		
	}

	public Instructor getDataInput() {
		Instructor i = new Instructor();
		try {
			i.setId(this.instructorIdInputTF.getText());
			i.setName(this.nameInputTF.getText());
			i.setLevel(this.levelCB.getItemAt(levelCB.getSelectedIndex()));
			i.setNationality(this.nationalityInputLb.getText());
			if (this.manRdbtn.isSelected()) {
				i.setGender("Nam");				
			} else if (this.womenRdbtn.isSelected()) {
				i.setGender("Nữ");
			}
			i.setMajor(this.majorInputCB.getItemAt(this.majorInputCB.getSelectedIndex()));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		 
		return i;
	}

	public boolean displayInfo() {
		try {
			int index = table.getSelectedRow();
			
			if (index == -1) return false;
			String id = table.getValueAt(index, 1)+"";
			String name = table.getValueAt(index, 2)+"";
			String level = table.getValueAt(index, 3)+"";
			String nationality = table.getValueAt(index, 4)+"";
			String gender = table.getValueAt(index, 5)+"";
			String major = table.getValueAt(index, 6)+"";
			
			this.instructorIdInputTF.setText(id);
			this.nameInputTF.setText(name);
			
			int levelIndex = -1;
	        String[] levelItems = {"Thạc sĩ", "Tiến sĩ", "Phó giáo sư tiến sĩ"};
	        for (int i = 0; i < levelItems.length; i++) {
	            if (level.equals(levelItems[i])) {
	                levelIndex = i;
	                break;
	            }
	        }
	        this.levelCB.setSelectedIndex(levelIndex);
			this.nationalityInputLb.setText(nationality);
			System.out.print(gender);
			if (gender.equals("Nam")) {
				this.manRdbtn.setSelected(true);
			} else if (gender.equals("Nữ")) {
				this.womenRdbtn.setSelected(true);
			}
			String[] items = Util.getAllMajorFromDb();
			int indexMajorCB = -1;
			for (int i = 0; i < items.length; i++) {
				if (major.equals(items[i])) {
					indexMajorCB = i;
					break;
				}
			}
			this.majorInputCB.setSelectedIndex(indexMajorCB);
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@SuppressWarnings("deprecation")
	public void rePaintBtn() {
		if (option.equals("UPDATE_OPTION")) {
			this.saveBtn.setLabel("Cập nhật");
		} else if (option.equals("CREATE_OPTION") || option.equals("DEFAULT_OPTION")) {
			this.saveBtn.setLabel("Thêm");
		}
	}	
}
