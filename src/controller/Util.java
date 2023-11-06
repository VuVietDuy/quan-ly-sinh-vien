package controller;

import java.util.ArrayList;
import java.util.List;

import dao.ClassDAO;
import dao.MajorDAO;
import model.Major;
import model._Class;

public class Util {
	public static String[] getAllMajorFromDb() {
		List<Major> list = new ArrayList<Major>();
		list = MajorDAO.getInstance().getAll();
		
		int n = list.size();
		String res[] = new String[n];
		
		int i = 0;
		for (Major m : list) {
			res[i] = m.getName();
			i++;
		}
		
		return res;
	}
	
	public static String[] getAllClassFromDb() {
		List<_Class> list = new ArrayList<_Class>();
		list = ClassDAO.getInstance().getAll();
		
		int n = list.size();
		String res[] = new String[n];
		
		int i = 0;
		for (_Class c : list) {
			res[i] = c.getId();
			i++;
		}
		
		return res;
	}
}