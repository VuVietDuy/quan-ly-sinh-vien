package view;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import controller.ClassController;
import model._Class;


public class ClassManagementView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField classIdInputTF;
	private JTextField adviserInputTF;
	private JTextField majorInputTF;
	private JTextField noteInputTF;
	private String option;
	private ClassController classController;
	private JButton saveBtn;

	/**
	 * Create the panel.
	 */
	public ClassManagementView() {
		classController = new ClassController(this);
		option = "DEFAULT_OPTION";
		
		setLayout(null);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		inputPanel.setBounds(10, 11, 764, 150);
		add(inputPanel);
		inputPanel.setLayout(null);
		
		JButton createBtn = new JButton("Thêm +");
		createBtn.setForeground(new Color(255, 255, 255));
		createBtn.setBackground(new Color(0, 128, 0));
		createBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		createBtn.setBounds(664, 13, 90, 32);
		inputPanel.add(createBtn);
		createBtn.addActionListener(classController);
		
		JButton updateBtn = new JButton("Sửa");
		updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateBtn.setBounds(664, 58, 90, 32);
		inputPanel.add(updateBtn);
		updateBtn.addActionListener(classController);
		
		JButton deleteBtn = new JButton("Xoá");
		deleteBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteBtn.setBounds(664, 103, 90, 32);
		inputPanel.add(deleteBtn);
		deleteBtn.addActionListener(classController);
		
		saveBtn = new JButton("Thêm");
		saveBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		saveBtn.setBounds(402, 103, 90, 32);
		inputPanel.add(saveBtn);
		saveBtn.addActionListener(classController);
		
		JButton exitBtn = new JButton("Huỷ bỏ");
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		exitBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		exitBtn.setBounds(510, 103, 90, 32);
		inputPanel.add(exitBtn);
		exitBtn.addActionListener(classController);
		
		classIdInputTF = new JTextField();
		classIdInputTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		classIdInputTF.setBounds(68, 13, 198, 32);
		inputPanel.add(classIdInputTF);
		classIdInputTF.setColumns(10);
		
		JLabel classIdLb = new JLabel("Mã lớp");
		classIdLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		classIdLb.setBounds(10, 13, 55, 32);
		inputPanel.add(classIdLb);
		
		JLabel adviserLb = new JLabel("Cố vấn");
		adviserLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		adviserLb.setBounds(10, 58, 55, 32);
		inputPanel.add(adviserLb);
		
		adviserInputTF = new JTextField();
		adviserInputTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		adviserInputTF.setColumns(10);
		adviserInputTF.setBounds(68, 58, 198, 32);
		inputPanel.add(adviserInputTF);
		
		JLabel majorLb = new JLabel("Khoa");
		majorLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		majorLb.setBounds(10, 103, 55, 32);
		inputPanel.add(majorLb);
		
		majorInputTF = new JTextField();
		majorInputTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		majorInputTF.setColumns(10);
		majorInputTF.setBounds(68, 103, 198, 32);
		inputPanel.add(majorInputTF);
		
		JLabel noteLb = new JLabel("Ghi chú");
		noteLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		noteLb.setBounds(337, 13, 55, 32);
		inputPanel.add(noteLb);
		
		noteInputTF = new JTextField();
		noteInputTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		noteInputTF.setColumns(10);
		noteInputTF.setBounds(402, 14, 198, 32);
		inputPanel.add(noteInputTF);
		
		JPanel classListPanel = new JPanel();
		classListPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		classListPanel.setBounds(10, 172, 764, 355);
		add(classListPanel);
		classListPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 744, 308);
		classListPanel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Stt", "M\u00E3 l\u1EDBp", "C\u1ED1 v\u1EA5n", "Khoa", "Ghi ch\u00FA"
			}
		));
		table.setRowHeight(24);
		table.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 15 ));
		scrollPane.setViewportView(table);
		this.addDataIntoTable();
		
		JLabel classListLb = new JLabel("Danh sách lớp hành chính");
		classListLb.setBounds(10, 11, 167, 14);
		classListPanel.add(classListLb);
		classListLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}

	public boolean displayInfo() {
		
		try {
			TableModel model = table.getModel();
			int indexRow = table.getSelectedRow();
			if (indexRow == -1) {
				return false;
			}
			System.out.println(indexRow);
			
			String classId = model.getValueAt(indexRow, 1)+"";
			String adviser = model.getValueAt(indexRow, 2)+"";
			String major = model.getValueAt(indexRow, 3)+"";
			String note = model.getValueAt(indexRow, 4)+"";
			
			classIdInputTF.setText(classId);
			adviserInputTF.setText(adviser);
			majorInputTF.setText(major);
			noteInputTF.setText(note);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("display info faile");
			return false;
		}
		return true;
	}

	public void exitForm() {
		// TODO Auto-generated method stub
		classIdInputTF.setText("");
		adviserInputTF.setText("");
		majorInputTF.setText("");
		noteInputTF.setText("");
	}

	public void addRow(_Class c) {
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		defaultTableModel.addRow(new Object[] {
				1,
				c.getId(),
				c.getAdviser(),
				c.getMajor(),
				c.getNote()
		});
		// TODO Auto-generated method stub
		
	}

	public _Class getDataInput() {
		// TODO Auto-generated method stub
		_Class c = new _Class();
		try {
			c.setId(this.classIdInputTF.getText());
			c.setAdviser(this.adviserInputTF.getText());
			c.setMajor(this.majorInputTF.getText());
			c.setNote(this.noteInputTF.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return c;
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
	
	public int getRowSelected() {
		return table.getSelectedRow();
	}
	
	public void addDataIntoTable() {
		List<_Class> classes = new ArrayList<_Class>();
		classes = this.classController.getDataFromDb();
		DefaultTableModel defaultTableModel = (DefaultTableModel) table.getModel();
		
		int stt = 1;
		while (defaultTableModel.getRowCount() > 0) {
			defaultTableModel.removeRow(0);
        }
		for (_Class c : classes) {
			defaultTableModel.addRow(new Object[] {
					stt,
					c.getId(),
					c.getAdviser(),
					c.getMajor(),
					c.getNote()
			});
			stt++;
		}
		table.revalidate();
		table.repaint();
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
