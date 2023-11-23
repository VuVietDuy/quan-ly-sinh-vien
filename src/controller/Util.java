package controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

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
	
	public static void exportToExcel(DefaultTableModel model, String filePath) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet1");

        // Tạo dòng đầu tiên là tiêu đề
        Row headerRow = sheet.createRow(0);
        for (int col = 0; col < model.getColumnCount(); col++) {
            Cell cell = headerRow.createCell(col);
            cell.setCellValue(model.getColumnName(col));
        }

        // Xuất dữ liệu từ bảng vào file Excel
        for (int row = 0; row < model.getRowCount(); row++) {
            Row excelRow = sheet.createRow(row + 1); // Bắt đầu từ dòng thứ 2 để tránh ghi đè tiêu đề
            for (int col = 0; col < model.getColumnCount(); col++) {
                Cell cell = excelRow.createCell(col);
                cell.setCellValue(String.valueOf(model.getValueAt(row, col)));
            }
        }

        // Lưu workbook vào file
        try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}