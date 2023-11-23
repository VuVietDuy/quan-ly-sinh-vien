package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.Collections;
import java.util.List;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

import controller.StudentController;
import controller.Util;
import model.Gender;
import model.Student;

public class StudentManagementView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable tableStudent;
	private JTextField maSVSearchTF;
	private JTextField maSVInputTF;
	private JTextField nameInputTF;
	private JTextField birthInputTF;
	private JTextField addressInputTF;
	private ButtonGroup genderRdbtn;
	private String option;
	private JRadioButton manRdbtn;
	private JRadioButton womenRdbtn;
	private JTextField classInputTF;
	private JComboBox<String> sortByCB;
	private StudentController studentController;
	private JButton saveBtn;
	private JComboBox<String> classOptionSearchCB;
	private JComboBox<String> majorInputCB;
	private List<Student> students;

	/**
	 ** Create the panel.
	 */
	public StudentManagementView() {
		
		this.studentController = new StudentController(this);
		this.option = "DEFAULT_OPTION";
        
		setLayout(null);
		
		JPanel filterPanel = new JPanel();
		filterPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		filterPanel.setBounds(10, 11, 978, 59);
		add(filterPanel);
		filterPanel.setLayout(null);
		
		maSVSearchTF = new JTextField();
		maSVSearchTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		maSVSearchTF.setBounds(122, 13, 150, 32);
		filterPanel.add(maSVSearchTF);
		maSVSearchTF.setColumns(10);
		
		JLabel maSvSearchLb = new JLabel("Tìm mã sinh viên");
		maSvSearchLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		maSvSearchLb.setBounds(10, 11, 102, 32);
		filterPanel.add(maSvSearchLb);
		
		JButton searchBtn = new JButton("Tìm kiếm");
		searchBtn.setForeground(new Color(255, 255, 255));
		searchBtn.setBackground(new Color(0, 128, 0));
		searchBtn.addActionListener(studentController);
		
		searchBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		searchBtn.setBounds(866, 12, 102, 32);
		filterPanel.add(searchBtn);
		
		String[] itemsClassCB = Util.getAllClassFromDb();
		classOptionSearchCB = new JComboBox<>(itemsClassCB);
		classOptionSearchCB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		classOptionSearchCB.setBounds(364, 13, 120, 32);
		filterPanel.add(classOptionSearchCB);
		classOptionSearchCB.setSelectedIndex(-1);
		
		JLabel classOptionSearchLb = new JLabel("Chọn lớp");
		classOptionSearchLb.setBounds(300, 13, 55, 32);
		filterPanel.add(classOptionSearchLb);
		classOptionSearchLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		String [] items = {"Mã sinh viên", "Tên"};
		sortByCB = new JComboBox<>(items);
		sortByCB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		sortByCB.setBounds(679, 12, 120, 32);
		filterPanel.add(sortByCB);
		sortByCB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedOption = (String) sortByCB.getSelectedItem();
                
                if (selectedOption.equals("Tên")) {
                	Collections.sort(students);                	
                } else {
                	students = studentController.getDataFromDb();
                }

                addDataIntoTable(students);
            }
        });
		
		JLabel lblSortBy = new JLabel("Sort by");
		lblSortBy.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSortBy.setBounds(614, 13, 55, 32);
		filterPanel.add(lblSortBy);
		
		JPanel listStudentPanel = new JPanel();
		listStudentPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		listStudentPanel.setBounds(10, 75, 978, 314);
		add(listStudentPanel);
		listStudentPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 958, 267);
		listStudentPanel.add(scrollPane);
		
		tableStudent = new JTable();
		tableStudent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableStudent.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Stt", "M\u00E3 sinh vi\u00EAn", "H\u1ECD v\u00E0 t\u00EAn", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "Qu\u00EA qu\u00E1n", "Ngành", "L\u1EDBp"
			}
		));
		tableStudent.setRowHeight(24);
		tableStudent.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 15 ));
		scrollPane.setViewportView(tableStudent);
		this.addDataIntoTable(studentController.getDataFromDb());
		
		JLabel listStudentLb = new JLabel("Danh sách sinh viên");
		listStudentLb.setBounds(10, 11, 122, 14);
		listStudentPanel.add(listStudentLb);
		listStudentLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(null);
		inputPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		inputPanel.setBounds(10, 400, 978, 200);
		add(inputPanel);
		
		JButton createBtn = new JButton("Thêm +");
		createBtn.setForeground(Color.WHITE);
		createBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		createBtn.setBackground(new Color(0, 128, 0));
		createBtn.setBounds(878, 60, 90, 32);
		inputPanel.add(createBtn);
		createBtn.addActionListener(studentController);
		
		JButton updateBtn = new JButton("Sửa");
		updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateBtn.setBounds(878, 106, 90, 32);
		inputPanel.add(updateBtn);
		updateBtn.addActionListener(studentController);
		
		JButton deleteBtn = new JButton("Xoá");
		deleteBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteBtn.setBounds(878, 152, 90, 32);
		inputPanel.add(deleteBtn);
		deleteBtn.addActionListener(studentController);
		
		saveBtn = new JButton("Thêm");
		saveBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		saveBtn.setBounds(526, 152, 90, 32);
		inputPanel.add(saveBtn);
		saveBtn.addActionListener(studentController);
		
		JButton exitBtn = new JButton("Huỷ bỏ");
		exitBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		exitBtn.setBounds(634, 152, 90, 32);
		inputPanel.add(exitBtn);
		exitBtn.addActionListener(studentController);
		
		maSVInputTF = new JTextField();
		maSVInputTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		maSVInputTF.setColumns(10);
		maSVInputTF.setBounds(100, 14, 300, 32);
		inputPanel.add(maSVInputTF);
		
		JLabel maSVLb = new JLabel("Mã sinh viên");
		maSVLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		maSVLb.setBounds(10, 14, 90, 32);
		inputPanel.add(maSVLb);
		
		JLabel nameLb = new JLabel("Họ và tên");
		nameLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameLb.setBounds(10, 60, 90, 32);
		inputPanel.add(nameLb);
		
		nameInputTF = new JTextField();
		nameInputTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		nameInputTF.setColumns(10);
		nameInputTF.setBounds(100, 60, 300, 32);
		inputPanel.add(nameInputTF);
		
		JLabel birthLb = new JLabel("Ngày sinh");
		birthLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		birthLb.setBounds(10, 106, 90, 32);
		inputPanel.add(birthLb);
		
		JLabel majorLb = new JLabel("Ngành");
		majorLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		majorLb.setBounds(460, 60, 53, 32);
		inputPanel.add(majorLb);
		
		JLabel genderLb = new JLabel("Giới tính");
		genderLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		genderLb.setBounds(460, 10, 66, 32);
		inputPanel.add(genderLb);

		manRdbtn = new JRadioButton("Nam");
		manRdbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		manRdbtn.setBounds(526, 14, 53, 32);
		inputPanel.add(manRdbtn);
		
		womenRdbtn = new JRadioButton("Nữ");
		womenRdbtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		womenRdbtn.setBounds(598, 14, 53, 32);
		inputPanel.add(womenRdbtn);
		
		genderRdbtn = new ButtonGroup();
		genderRdbtn.add(manRdbtn);
		genderRdbtn.add(womenRdbtn);
		
		JLabel classLb = new JLabel("Lớp");
		classLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		classLb.setBounds(460, 106, 53, 32);
		inputPanel.add(classLb);
		
		birthInputTF = new JTextField();
		birthInputTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		birthInputTF.setColumns(10);
		birthInputTF.setBounds(100, 106, 300, 32);
		inputPanel.add(birthInputTF);
		
		addressInputTF = new JTextField();
		addressInputTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addressInputTF.setColumns(10);
		addressInputTF.setBounds(100, 152, 300, 32);
		inputPanel.add(addressInputTF);
		
		JLabel addressLb = new JLabel("Quê quán");
		addressLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		addressLb.setBounds(10, 152, 90, 32);
		inputPanel.add(addressLb);
		
		String[] itemsMajorCB = Util.getAllMajorFromDb();
		majorInputCB = new JComboBox<>(itemsMajorCB);
		majorInputCB.setSelectedIndex(-1);
		majorInputCB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		majorInputCB.setBounds(526, 60, 300, 32);
		inputPanel.add(majorInputCB);
		
		classInputTF = new JTextField();
		classInputTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		classInputTF.setBounds(526, 106, 300, 32);
		inputPanel.add(classInputTF);
		
	}

	public void exitForm() {
		// TODO Auto-generated method stub
		maSVInputTF.setText("");
		nameInputTF.setText("");
		birthInputTF.setText("");
		addressInputTF.setText("");
		genderRdbtn.clearSelection();
		majorInputCB.setSelectedIndex(-1);
		classInputTF.setText("");
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
	
	public Student getDataInput() {
		Student student = new Student();
		
		try {
			student.setMaSV(this.maSVInputTF.getText());
			student.setName(this.nameInputTF.getText());
			student.setBirthday(this.birthInputTF.getText());

			if (this.manRdbtn.isSelected()) {
				student.setGender(Gender.Nam);				
			} else if (this.womenRdbtn.isSelected()) {
				student.setGender(Gender.Nữ);
			}
			
			student.set_class(classInputTF.getText());
			student.setMajor(majorInputCB.getItemAt(majorInputCB.getSelectedIndex()));
			student.setAddress(addressInputTF.getText());
		} catch(Exception e) {
			e.printStackTrace();
		}
		 
		return student;
	}
	
	public void addRow(Student student) {
		DefaultTableModel defaultTableModel = (DefaultTableModel) tableStudent.getModel();
		defaultTableModel.addRow(new Object[] {
				1,
				student.getMaSV(),
				student.getName(),
				student.getBirthday(),
				student.getGender(),
				student.getMajor(),
				student.get_class(),
		});
	}
	
	public boolean displayInfo() {
		DefaultTableModel model = (DefaultTableModel) tableStudent.getModel();
		int indexRow = tableStudent.getSelectedRow();
		
		if (indexRow == -1) return false;
		System.out.println(indexRow);
		String maSV = model.getValueAt(indexRow, 1)+"";
		String name = model.getValueAt(indexRow, 2)+"";
		String birth = model.getValueAt(indexRow, 3)+"";
		String gender = model.getValueAt(indexRow, 4)+"";
		String address = model.getValueAt(indexRow, 5)+"";
		String major = model.getValueAt(indexRow, 6)+"";
		String _class = model.getValueAt(indexRow, 7)+"";
		
		this.maSVInputTF.setText(maSV);
		this.nameInputTF.setText(name);
		this.birthInputTF.setText(birth);
		if (gender.equals("Nam")) {
			this.manRdbtn.setSelected(true);
		} else if (gender.equals("Nữ")) {
			this.womenRdbtn.setSelected(true);
		}
		this.addressInputTF.setText(address);
		String[] items = Util.getAllMajorFromDb();
		int indexMajorCB = -1;
		for (int i = 0; i < items.length; i++) {
			if (major.equals(items[i])) {
				indexMajorCB = i;
				break;
			}
		}
		this.majorInputCB.setSelectedIndex(indexMajorCB);
		
		this.classInputTF.setText(_class);
		
		return true;
	}

	public void addDataIntoTable(List<Student> students) {
		
		DefaultTableModel model = (DefaultTableModel) tableStudent.getModel();
		
		int stt = 1;
		while (model.getRowCount() > 0) {
			model.removeRow(0);
        }
		for (Student s : students) {
			model.addRow(new Object[] {
					stt,
					s.getMaSV(),
					s.getName(),
					s.getBirthday(),
					s.getGender(),
					s.getAddress(),
					s.getMajor(),
					s.get_class(),
			});
			stt++;
		}
		tableStudent.revalidate();
		tableStudent.repaint();
		this.students = students;
	}
	
	@SuppressWarnings("deprecation")
	public void rePaintBtn() {
		if (option.equals("UPDATE_OPTION")) {
			this.saveBtn.setLabel("Cập nhật");
		} else if (option.equals("CREATE_OPTION") || option.equals("DEFAULT_OPTION")) {
			this.saveBtn.setLabel("Thêm");
		}
	}

	public JTextField getMaSVSearchTF() {
		return maSVSearchTF;
	}

	public void setMaSVSearchTF(JTextField maSVSearchTF) {
		this.maSVSearchTF = maSVSearchTF;
	}

	public JComboBox<String> getClassOptionSearchCB() {
		return classOptionSearchCB;
	}

	public JComboBox<String> getSortByCB() {
		return sortByCB;
	}

	public void setSortByCB(JComboBox<String> sortByCB) {
		this.sortByCB = sortByCB;
	}

	public JTable getTableStudent() {
		return tableStudent;
	} 
}
