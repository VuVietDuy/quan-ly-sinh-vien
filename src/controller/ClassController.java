package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import dao.ClassDAO;
import model._Class;
import view.ClassManagementView;
import view.MessageDialog;

public class ClassController implements ActionListener{
	
	private ClassManagementView view;

	public ClassController(ClassManagementView classManagementView) {
		this.view = classManagementView;
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
				_Class c = view.getDataInput();
				
				MessageDialog message = new MessageDialog("Bạn có muốn xoá lớp này không?");
				
				message.getOkButton().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						boolean res = ClassDAO.getInstance().delete(c.getId());
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
			_Class c = view.getDataInput();
			System.out.println(c);
			
			// Interact database
			boolean res = ClassDAO.getInstance().insert(c);
			System.out.println("insert class is success: " + res);
			
			view.addDataIntoTable();
			view.exitForm();
			
			break;
		}
		case "Cập nhật": {
			// Interact view
			_Class c = view.getDataInput();
			System.out.println(c);
			
			// Interact database
			boolean res = ClassDAO.getInstance().update(c.getId(), c);
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
	
	public List<_Class> getDataFromDb() {
		List<_Class> res = new ArrayList<_Class>();
		res = ClassDAO.getInstance().getAll();
		return res;
	}
	
}
