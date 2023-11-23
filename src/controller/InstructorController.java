package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import dao.InstructorDAO;
import model.Instructor;
import view.InstructorManagementView;
import view.MessageDialog;

public class InstructorController implements ActionListener{
	
	private InstructorManagementView view;

	public InstructorController(InstructorManagementView instructorManagementView) {
		this.view = instructorManagementView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String btn = e.getActionCommand();
		System.out.println(btn);
		
		switch (btn) {
		case "Thêm +": {
			view.exitForm();
			view.setOption("CREATE_OPTION");
			view.addDataIntoTable();
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
				Instructor i = view.getDataInput();
				
				MessageDialog message = new MessageDialog("Bạn có muốn xoá giảng viên này không?");
				
				message.getOkButton().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						boolean res = InstructorDAO.getInstance().delete(i.getId());
						System.out.println("delete class is success: " + res);
						view.addDataIntoTable();
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
			Instructor i = view.getDataInput();
			System.out.println(i);
			
			// Interact database
			if (i != null) {
				boolean res = InstructorDAO.getInstance().insert(i);
				System.out.println("insert class is success: " + res);
				
				view.addDataIntoTable();
				view.exitForm();
			}
			
			
			break;
		}
		case "Cập nhật": {
			// Interact view
			Instructor i = view.getDataInput();
			System.out.println(i);
			
			// Interact database
			boolean res = InstructorDAO.getInstance().update(i.getId(), i);
			System.out.println("update class is success: " + res);
			
			view.exitForm();
			view.addDataIntoTable();
			view.setOption("DEFAULT_OPTION");
			break;
		}
		case "Huỷ bỏ" : {
			view.exitForm();
			view.setOption("DEFAULT_OPTION");
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + btn);
		}
	}
	
	public List<Instructor> getDataFromDb() {
		List<Instructor> res = new ArrayList<Instructor>();
		res = InstructorDAO.getInstance().getAll();
		return res;
	}
	
}
