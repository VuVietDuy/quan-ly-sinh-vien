package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import dao.ClassDAO;
import dao.MajorDAO;
import model.Major;
import view.MajorManagementView;
import view.MessageDialog;

public class MajorController implements ActionListener{
	
	private MajorManagementView view;

	public MajorController(MajorManagementView majorManagementView) {
		this.view = majorManagementView;
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
				Major c = view.getDataInput();
				
				MessageDialog message = new MessageDialog("Bạn có muốn xoá ngành này không?");
				
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
			Major m = view.getDataInput();
			System.out.println(m);
			
			// Interact database
			boolean res = MajorDAO.getInstance().insert(m);
			System.out.println("insert class is success: " + res);
			
			view.addDataIntoTable();
			view.exitForm();
			
			break;
		}
		case "Cập nhật": {
			// Interact view
			Major c = view.getDataInput();
			System.out.println(c);
			
			// Interact database
			boolean res = MajorDAO.getInstance().update(c.getId(), c);
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
	
	public List<Major> getDataFromDb() {
		List<Major> res = new ArrayList<Major>();
		res = MajorDAO.getInstance().getAll();
		return res;
	}
	
}
