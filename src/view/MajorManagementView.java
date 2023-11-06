package view;

import java.awt.Font;
import java.util.List;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import controller.MajorController;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import model.Major;

public class MajorManagementView extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField majorIdInputTF;
	private JTextField majorNameInputTF;
	private JTextField noteInputTF;
	private JComboBox<String> khoiNganhCB;
	private JButton saveBtn;
	private JButton exitBtn;
	private String option;
	private MajorController majorController;

	/**
	 * Create the panel.
	 */
	public MajorManagementView() {

		setLayout(null);
		
		majorController = new MajorController(this);
		
		JPanel inputPane = new JPanel();
		inputPane.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		inputPane.setBounds(10, 11, 764, 150);
		add(inputPane);
		inputPane.setLayout(null);
		
		JButton createBtn = new JButton("Thêm +");
		createBtn.setForeground(new Color(255, 255, 255));
		createBtn.setBackground(new Color(0, 128, 0));
		createBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		createBtn.setBounds(664, 13, 90, 32);
		inputPane.add(createBtn);
		createBtn.addActionListener(majorController);
		
		JButton updateBtn = new JButton("Sửa");
		updateBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		updateBtn.setBounds(664, 58, 90, 32);
		inputPane.add(updateBtn);
		updateBtn.addActionListener(majorController);
		
		JButton deleteBtn = new JButton("Xoá");
		deleteBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		deleteBtn.setBounds(664, 103, 90, 32);
		inputPane.add(deleteBtn);
		deleteBtn.addActionListener(majorController);

		saveBtn = new JButton("Thêm");
		saveBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		saveBtn.setBounds(400, 103, 90, 32);
		inputPane.add(saveBtn);
		saveBtn.addActionListener(majorController);
		
		exitBtn = new JButton("Huỷ bỏ");
		exitBtn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		exitBtn.setBounds(508, 103, 90, 32);
		inputPane.add(exitBtn);
		exitBtn.addActionListener(majorController);
		
		majorIdInputTF = new JTextField();
		majorIdInputTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		majorIdInputTF.setBounds(93, 13, 198, 32);
		inputPane.add(majorIdInputTF);
		
		JLabel majorIdLb = new JLabel("Mã khoa");
		majorIdLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		majorIdLb.setBounds(10, 13, 63, 32);
		inputPane.add(majorIdLb);
		
		JLabel majorNameLb = new JLabel("Tên khoa");
		majorNameLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		majorNameLb.setBounds(10, 58, 63, 32);
		inputPane.add(majorNameLb);
		
		majorNameInputTF = new JTextField();
		majorNameInputTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		majorNameInputTF.setColumns(10);
		majorNameInputTF.setBounds(93, 58, 198, 32);
		inputPane.add(majorNameInputTF);
		
		JLabel noteLb = new JLabel("Ghi chú");
		noteLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		noteLb.setBounds(327, 13, 63, 32);
		inputPane.add(noteLb);
		
		noteInputTF = new JTextField();
		noteInputTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		noteInputTF.setColumns(10);
		noteInputTF.setBounds(400, 11, 198, 32);
		inputPane.add(noteInputTF);
		
		JLabel khoiNganhLb = new JLabel("Khối ngành");
		khoiNganhLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		khoiNganhLb.setBounds(10, 103, 73, 32);
		inputPane.add(khoiNganhLb);
		
		String[] items = {"Kỹ thuật", "Kinh tế"};
		khoiNganhCB = new JComboBox<>(items);
		khoiNganhCB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		khoiNganhCB.setBounds(93, 103, 198, 32);
		inputPane.add(khoiNganhCB);
		
		JPanel majorListPanel = new JPanel();
		majorListPanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		majorListPanel.setBounds(10, 172, 764, 355);
		add(majorListPanel);
		majorListPanel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 744, 308);
		majorListPanel.add(scrollPane);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Stt", "Mã khoa", "Tên khoa", "Khối ngành", "Ghi chú"
			}
		));
		table.setRowHeight(24);
		table.getTableHeader().setFont( new Font( "Tahoma" , Font.BOLD, 15 ));
		scrollPane.setViewportView(table);
		this.addDataIntoTable();
		
		JLabel majorListLb = new JLabel("Danh sách khoa");
		majorListLb.setBounds(10, 11, 139, 14);
		majorListPanel.add(majorListLb);
		majorListLb.setFont(new Font("Tahoma", Font.PLAIN, 14));
	}

	public void exitForm() {
		this.majorIdInputTF.setText("");
		this.majorNameInputTF.setText("");
		this.khoiNganhCB.setSelectedIndex(-1);
		this.noteInputTF.setText("");
		
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
		List<Major> list = majorController.getDataFromDb();
		
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		while (model.getRowCount() > 0) {
			model.removeRow(0);
        }
		int stt = 1;
		for (Major major : list) {
			model.addRow(new Object[] {
				stt,
				major.getId(),
				major.getName(),
				major.getKhoiNganh(),
				major.getNote(),
			});
			stt++;
		}
		table.revalidate();
		table.repaint();
	}

	public boolean displayInfo() {
		
		try {
			TableModel model = table.getModel();
			int indexRow = table.getSelectedRow();
			if (indexRow == -1) {
				return false;
			}
			System.out.println(indexRow);
			
			String id = model.getValueAt(indexRow, 1)+"";
			String name = model.getValueAt(indexRow, 2)+"";
			String khoiNganh = model.getValueAt(indexRow, 3)+"";
			String note = model.getValueAt(indexRow, 4)+"";
			
			this.majorIdInputTF.setText(id);
			this.majorNameInputTF.setText(name);
			this.khoiNganhCB.setSelectedItem(khoiNganh);
			this.noteInputTF.setText(note);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("display info faile");
			return false;
		}
		return true;
	}

	public Major getDataInput() {
		Major major = new Major();
		
		major.setId(majorIdInputTF.getText());
		major.setName(majorNameInputTF.getText());
		major.setKhoiNganh(khoiNganhCB.getSelectedItem()+"");
		major.setNote(noteInputTF.getText());
		
		return major;
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
