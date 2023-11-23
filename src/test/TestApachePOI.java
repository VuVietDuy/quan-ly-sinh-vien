package test;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import main.Main;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestApachePOI {
	public static void main(String[] args) {
		MainFrame m = new MainFrame();
	}
}

class MainFrame extends JFrame {
    private JTable table;

    public MainFrame() {
        // ... Khởi tạo và thêm dữ liệu vào table
    	JTable table = new JTable();
    	table.setFont(new Font("Tahoma", Font.PLAIN, 14));
    	table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Vu Viet DUy", "Vu VIet DUy", "Vux Boeag", "asdgas", "Vu VIet DUy", "Vu VIet DUy", "Vu VIet DUy", "Vu VIet DUy"},
				{"Vu Viet DUy", "Vu VIet DUy", "Vux Boeag", "asdgas", "Vu VIet DUy", "Vu VIet DUy", "Vu VIet DUy", "Vu VIet DUy"},
				{"Vu Viet DUy", "Vu VIet DUy", "Vux Boeag", "asdgas", "Vu VIet DUy", "Vu VIet DUy", "Vu VIet DUy", "Vu VIet DUy"},
				{"Vu Viet DUy", "Vu VIet DUy", "Vux Boeag", "asdgas", "Vu VIet DUy", "Vu VIet DUy", "Vu VIet DUy", "Vu VIet DUy"},
				{"Vu Viet DUy", "Vu VIet DUy", "Vux Boeag", "asdgas", "Vu VIet DUy", "Vu VIet DUy", "Vu VIet DUy", "Vu VIet DUy"},
				{"Vu Viet DUy", "Vu VIet DUy", "Vux Boeag", "asdgas", "Vu VIet DUy", "Vu VIet DUy", "Vu VIet DUy", "Vu VIet DUy"},
			},
			new String[] {
				"Stt", "M\u00E3 sinh vi\u00EAn", "H\u1ECD v\u00E0 t\u00EAn", "Ng\u00E0y sinh", "Gi\u1EDBi t\u00EDnh", "Quê quán", "Khoa", "L\u1EDBp"
			}
		));

        JButton exportButton = new JButton("Export to Excel");
        exportButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setDialogTitle("Specify a file to save");
                int userSelection = fileChooser.showSaveDialog(null);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath() + ".xlsx";
                    ExcelExporter.exportToExcel((DefaultTableModel) table.getModel(), filePath);
                    JOptionPane.showMessageDialog(null, "Exported to Excel successfully!");
                }
            }
        });

        // ... Thêm các thành phần còn lại vào frame
        this.setLayout(new BorderLayout());
        this.add(table, BorderLayout.CENTER);
        this.add(exportButton, BorderLayout.SOUTH);
        this.setVisible(true);
    }

}


class ExcelExporter {
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
