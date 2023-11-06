package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import dao.StudentDAO;
import model.Student;
import view.MessageDialog;
import view.StudentManagementView;

public class StudentController implements ActionListener{
	
	private StudentManagementView view;

	public StudentController(StudentManagementView studentManagementView) {
		this.view = studentManagementView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String btn = e.getActionCommand();
		System.out.println(btn);
		
		switch (btn) {
		case "Thêm +": {
			view.exitForm();
			view.setOption("CREATE_OPTION");
			view.addDataIntoTable(getDataFromDb());
			break;
		}
		case "Sửa": {
			if(view.displayInfo()) {
				view.setOption("UPDATE_OPTION");				
			}
			break;
		}
		case "Xoá": {
			if (view.displayInfo()) {
				Student s = view.getDataInput();
				
				MessageDialog message = new MessageDialog("Bạn có muốn xoá sinh viên này không?");
				
				message.getOkButton().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						boolean res = StudentDAO.getInstance().delete(s.getMaSV());
						System.out.println("delete class is success: " + res);
						view.addDataIntoTable(getDataFromDb());
						view.exitForm();
						view.setOption("DEFAULT_OPTION");
						message.dispose();
					}
				});
				
				message.getCancelButton().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						view.setOption("UPDATE_OPTION");
						message.dispose();
					}
				});
				
				message.setVisible(true);				
			}

			break;
		}
		case "Thêm": {
			// Interact view
			Student s = view.getDataInput();
			System.out.println(s);
			
			// Interact database
			boolean res = StudentDAO.getInstance().insert(s);
			System.out.println("insert class is success: " + res);
			
			view.addDataIntoTable(getDataFromDb());
			view.exitForm();
			
			break;
		}
		case "Cập nhật": {
			// Interact view
			Student s = view.getDataInput();
			System.out.println(s);
			
			// Interact database
			boolean res = StudentDAO.getInstance().update(s.getMaSV(), s);
			System.out.println("update class is success: " + res);
			
			view.exitForm();
			view.addDataIntoTable(getDataFromDb());
			view.setOption("DEFAULT_OPTION");
			break;
		}
		case "Huỷ bỏ" : {
			view.exitForm();
			view.setOption("DEFAULT_OPTION");
			break;
		}
		case "Tìm kiếm" : {
			
			List<Student> students = StudentDAO.getInstance().searchStudent(view.getMaSVSearchTF().getText(), view.getClassOptionSearchCB().getText());
			view.addDataIntoTable(students);
			for (Student student : students) {
				System.out.println(student);
			}
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + btn);
		}
	}
	
	public List<Student> getDataFromDb() {
		List<Student> res = new ArrayList<Student>();
		res = StudentDAO.getInstance().getAll();
		return res;
	}
	
}
