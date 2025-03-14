package BELAJAR_SELENIUM.DataDrivenTesting;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WritingDataToExcel {
    /*
        langkah2 pemrosesan data excel:
        Excel File -> Workbook -> Sheets -> Rows -> Cells

        FileInputStream = Reading file
        FileOutputStream = Writing file

        XSSFWorkbook = Workbook
        XSSFSheet = sheet
        XSSFRow = Row
        XSSFCell = Cell
     */
    public static void main(String[] args) throws IOException {
        // Excel file
        FileOutputStream outputStream = new FileOutputStream(System.getProperty("user.dir")+"\\src\\test\\java\\testData\\myfile.xlsx");
        // Workbook
        XSSFWorkbook workbook = new XSSFWorkbook();
        // Sheet
        XSSFSheet sheet = workbook.createSheet("Data");
        //Row
        XSSFRow row1 = sheet.createRow(0);
        // Cell
        row1.createCell(0).setCellValue("Welcome");
        row1.createCell(1).setCellValue(1234);
        row1.createCell(2).setCellValue("Automation");

        XSSFRow row2 = sheet.createRow(1);
        row2.createCell(0).setCellValue("Python");
        row2.createCell(1).setCellValue(3);
        row2.createCell(2).setCellValue("Automation");

        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
    }
}
